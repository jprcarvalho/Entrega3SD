@REM ----------------------------------------------------------------------------
@REM  Copyright 2001-2006 The Apache Software Foundation.
@REM
@REM  Licensed under the Apache License, Version 2.0 (the "License");
@REM  you may not use this file except in compliance with the License.
@REM  You may obtain a copy of the License at
@REM
@REM       http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM  Unless required by applicable law or agreed to in writing, software
@REM  distributed under the License is distributed on an "AS IS" BASIS,
@REM  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM  See the License for the specific language governing permissions and
@REM  limitations under the License.
@REM ----------------------------------------------------------------------------
@REM
@REM   Copyright (c) 2001-2006 The Apache Software Foundation.  All rights
@REM   reserved.

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup
set REPO=


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\com\sun\xml\ws\jaxws-rt\2.2.10\jaxws-rt-2.2.10.jar;"%REPO%"\javax\xml\bind\jaxb-api\2.2.12-b140109.1041\jaxb-api-2.2.12-b140109.1041.jar;"%REPO%"\javax\xml\ws\jaxws-api\2.2.11\jaxws-api-2.2.11.jar;"%REPO%"\javax\xml\soap\javax.xml.soap-api\1.3.7\javax.xml.soap-api-1.3.7.jar;"%REPO%"\javax\annotation\javax.annotation-api\1.2\javax.annotation-api-1.2.jar;"%REPO%"\javax\jws\jsr181-api\1.0-MR1\jsr181-api-1.0-MR1.jar;"%REPO%"\com\sun\xml\bind\jaxb-core\2.2.10-b140802.1033\jaxb-core-2.2.10-b140802.1033.jar;"%REPO%"\com\sun\xml\bind\jaxb-impl\2.2.10-b140802.1033\jaxb-impl-2.2.10-b140802.1033.jar;"%REPO%"\com\sun\xml\ws\policy\2.4\policy-2.4.jar;"%REPO%"\org\glassfish\gmbal\gmbal-api-only\3.1.0-b001\gmbal-api-only-3.1.0-b001.jar;"%REPO%"\org\glassfish\external\management-api\3.0.0-b012\management-api-3.0.0-b012.jar;"%REPO%"\org\jvnet\staxex\stax-ex\1.7.7\stax-ex-1.7.7.jar;"%REPO%"\com\sun\xml\stream\buffer\streambuffer\1.5.3\streambuffer-1.5.3.jar;"%REPO%"\org\jvnet\mimepull\mimepull\1.9.4\mimepull-1.9.4.jar;"%REPO%"\com\sun\xml\fastinfoset\FastInfoset\1.2.13\FastInfoset-1.2.13.jar;"%REPO%"\org\glassfish\ha\ha-api\3.1.9\ha-api-3.1.9.jar;"%REPO%"\com\sun\xml\messaging\saaj\saaj-impl\1.3.25\saaj-impl-1.3.25.jar;"%REPO%"\org\codehaus\woodstox\woodstox-core-asl\4.2.0\woodstox-core-asl-4.2.0.jar;"%REPO%"\org\codehaus\woodstox\stax2-api\3.1.1\stax2-api-3.1.1.jar;"%REPO%"\com\sun\org\apache\xml\internal\resolver\20050927\resolver-20050927.jar;"%REPO%"\pt\ulisboa\tecnico\sdis\uddi-naming\1.2\uddi-naming-1.2.jar;"%REPO%"\javax\xml\registry\javax.xml.registry-api\1.0.5\javax.xml.registry-api-1.0.5.jar;"%REPO%"\org\apache\juddi\uddi-ws\3.1.4\uddi-ws-3.1.4.jar;"%REPO%"\org\apache\juddi\juddi-client\3.1.4\juddi-client-3.1.4.jar;"%REPO%"\commons-configuration\commons-configuration\1.6\commons-configuration-1.6.jar;"%REPO%"\commons-collections\commons-collections\3.2.1\commons-collections-3.2.1.jar;"%REPO%"\commons-lang\commons-lang\2.4\commons-lang-2.4.jar;"%REPO%"\commons-digester\commons-digester\1.8\commons-digester-1.8.jar;"%REPO%"\commons-beanutils\commons-beanutils-core\1.8.0\commons-beanutils-core-1.8.0.jar;"%REPO%"\wsdl4j\wsdl4j\1.6.2\wsdl4j-1.6.2.jar;"%REPO%"\org\apache\juddi\scout\scout\1.2.7\scout-1.2.7.jar;"%REPO%"\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar;"%REPO%"\org\komparator\A15\supplier-ws-cli\1.0-SNAPSHOT\supplier-ws-cli-1.0-SNAPSHOT.jar;"%REPO%"\org\komparator\A15\cc-ws-cli\1.0-SNAPSHOT\cc-ws-cli-1.0-SNAPSHOT.jar;"%REPO%"\org\komparator\A15\security\1.0-SNAPSHOT\security-1.0-SNAPSHOT.jar;"%REPO%"\org\komparator\A15\mediator-ws\1.0-SNAPSHOT\mediator-ws-1.0-SNAPSHOT.jar

set ENDORSED_DIR=
if NOT "%ENDORSED_DIR%" == "" set CLASSPATH="%BASEDIR%"\%ENDORSED_DIR%\*;%CLASSPATH%

if NOT "%CLASSPATH_PREFIX%" == "" set CLASSPATH=%CLASSPATH_PREFIX%;%CLASSPATH%

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS%  -classpath %CLASSPATH% -Dapp.name="mediator-ws" -Dapp.repo="%REPO%" -Dapp.home="%BASEDIR%" -Dbasedir="%BASEDIR%" org.komparator.mediator.ws.MediatorApp %CMD_LINE_ARGS%
if %ERRORLEVEL% NEQ 0 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=%ERRORLEVEL%

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@REM If error code is set to 1 then the endlocal was done already in :error.
if %ERROR_CODE% EQU 0 @endlocal


:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
