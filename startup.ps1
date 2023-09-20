$root = Get-Location;
$ConEmuInstances = (Get-Process -erroraction 'silentlycontinue' -Name ConEmuC64).count
function Invoke-WindowsTerminalTabs {
    wt -w 0 nt -d "$root./application/web/source" --title "CLIENT" PowerShell -NoExit -c npm run dev;
    wt -w 0 nt -d "$root./application/web/test" --title "CLIENT-TEST";
    wt -w 0 nt -d "$root./service/tekmart-service/source" --title "SERVICE" PowerShell -NoExit -c ./mvnw clean spring-boot:run;
    wt -w 0 nt -d "$root./service/tekmart-service/test" --title "SERVICE-TEST";
    wt -w 0 nt -d "$root./application/web/source" --title "CLIENT-UNIT";
    wt -w 0 nt -d "$root./service/tekmart-service" --title "SERVICE-UNIT";
}

if ($env:WT_SESSION) {
    Invoke-WindowsTerminalTabs
}
elseif ($ConEmuInstances -gt 0) {
    Start-RWEnvironment
}
else {
    Write-Host "You are not in windows terminal or ConEmu unable to open tabs" -ForegroundColor Red
}

