package com.tekgs.nextgen.tekmart;

import com.google.gson.Gson;
import com.softwareonpurpose.calibrator4test.Calibrator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class ListCalibrator<I, C> extends Calibrator {
    private final Class<I> childCalibratable;
    private final Class<C> childCalibrator;

    protected ListCalibrator(String description, Object expected, Object actual, Class<I> childCalibratable, Class<C> childCalibrator) {
        super(description, expected, actual);
        this.childCalibratable = childCalibratable;
        this.childCalibrator = childCalibrator;
    }

    private Method setGetInstance() {
        Method getInstance = null;
        for (Method method : this.childCalibrator.getMethods()) {
            if (method.getName().equals("getInstance")) {
                getInstance = method;
            }
        }
        if(getInstance == null){
            throw new NullPointerException("Couldn't find method getInstance in class " + childCalibrator.getCanonicalName());
        }
        return getInstance;
    }

    private void executeAddChildCalibrator(Object calibratableExpected, Object calibratableActual) {
        Method getInstance = setGetInstance();
        try {
            addChildCalibrator((Calibrator) getInstance.invoke(this.childCalibrator, calibratableExpected, calibratableActual));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Method setEquivalent() {
        Method equivalent = null;
        for (Method method : this.childCalibratable.getMethods()) {
            if (method.getName().equals("equivalent")) {
                equivalent = method;
            }
        }
        return equivalent;
    }

    public Boolean executeEquivalent(Object calibratableActual, Object comparator) {
        Method equivalent = setEquivalent();
        Boolean isEquivalent;
        try {
            isEquivalent = (Boolean) equivalent.invoke(calibratableActual, comparator);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return isEquivalent;
    }

    public void addCalibrationsExpected(List<I> listExpected, List<I> listActual) {
        for (I calibratableExpected : listExpected) {
            I calibratableActual = searchCalibratableActual(listActual, calibratableExpected);
            if (calibratableActual != null) {
                listActual.remove(calibratableActual);
            } else {
                Gson gson = new Gson();
                throw new NullPointerException("calibratableActual is not found, listActual: " + gson.toJson(listActual) + "; listExpected: " + gson.toJson(listExpected));
            }
            this.executeAddChildCalibrator(calibratableExpected, calibratableActual);
        }
    }

    private I searchCalibratableActual(List<I> listActual, I calibratableExpected) {
        I calibratableFound = null;

        for (I calibratableActual : listActual) {
            if (this.executeEquivalent(calibratableActual, calibratableExpected)) {
                calibratableFound = calibratableActual;
                break;
            }
        }
        return calibratableFound;
    }

    public void addCalibrationsUnexpected(List<I> listActual) {
        for (I calibratableActual : listActual) {
            executeAddChildCalibrator(null, calibratableActual);
        }
    }
}