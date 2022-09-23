echo running...
SET PATH=%PATH%;D:\Project\AutomationProject\target\lib\ant\bin
cd D:\Project\AutomationProject
ant -buildfile buildTemp.xml -DtestngXml=Plans\Plan.xml
pause
