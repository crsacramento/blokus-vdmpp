@echo off
rem Runs a collection of VDM++ test examples
rem Assumes specification is in Word RTF files

set S2=Piece.rtf
set S3=Board.rtf
set S4=Player.rtf
set S5=Game.rtf
set T1=Test.rtf
set T2=TestPiece.rtf
set T3=TestPlayer.rtf
set T4=TestBoard.rtf
set T5=TestGame.rtf


"C:\Program Files\The VDM++ Toolbox Academic v8.0\bin\vppde" -p -R vdm.tc %S2% %S3% %S4% %S5% %T1% %T2% %T3% %T4% %T5%
for /R %%f in (*.arg) do call vdmtest "%%f"
