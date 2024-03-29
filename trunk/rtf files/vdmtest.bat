@echo off
rem Tests the date book specification for one test case (argument)
rem -- Output the argument to stdout (for redirect) and "con" (for user feedback)
echo VDM Test: '%1' > con
echo VDM Test: '%1'

rem short names for specification files in Word RTF Format
set S2=Piece.rtf
set S3=Board.rtf
set S4=Player.rtf
set S5=Game.rtf
set T1=Test.rtf
set T2=TestPiece.rtf
set T3=TestPlayer.rtf
set T4=TestBoard.rtf
set T5=TestGame.rtf

rem -- Calls the interpreter for this test case
"C:\Program Files\The VDM++ Toolbox Academic v8.0\bin\vppde" -i -D -I -P -Q -R vdm.tc -O %1.res %1 %S2% %S3% %S4% %S5% %T1% %T2% %T3% %T4% %T5%

rem -- Check for difference between result of execution and expected result.
if EXIST %1.exp fc /w %1.res %1.exp

:end
