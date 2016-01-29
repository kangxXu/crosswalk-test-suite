## Introduction

This test suite is for testing sampleapp-android-tests specification

## Precondition

1. Set CROSSWALK_APP_TOOLS_CACHE_DIR
  ```export CROSSWALK_APP_TOOLS_CACHE_DIR=[local-path]```

2. Clone crosswalk-app-tools to CROSSWALK_APP_TOOLS_CACHE_DIR
   ```
   git clone https://github.com/crosswalk-project/crosswalk-app-tools
   cd crosswalk-app-tools
   sudo npm install
   ```
3. Download the crosswalk zip you want to test to CROSSWALK_APP_TOOLS_CACHE_DIR

4. Modify arch and mode in tests-conf.json for test platform.

## Test Step

1. Copy the source code folder named like crosswalk-samples to the path /tmp/

2. unzip sampleapp-android-tests<version>.zip -d [testprefix-path]

3. cd [testprefix-path]/opt/sampleapp-android-tests/

4. run test case

   testkit-lite -f [testprefix-path]/opt/sampleapp-android-tests/tests.xml -A
   -o [testprefix-path]/opt/sampleapp-android-tests/result.xml --comm androidmobile
   --testenvs "DEVICE_ID=Medfield3C6DFF2E;CHANNEL=canary;XWALK_VERSION=15.44.375.0"
   --testprefix=[testprefix-path]

   DEVICE_ID can also be multiple ids like "DEVICE_ID=Medfield3C6DFF2E,Medfield3C6DFF00".
   Query device id by command "adb devices -l" in host.

## Authors:

* Xu,Yuhan <yuhanx.xu@intel.com>
* Li, cici <cici.x.li@intel.com>
* Wang, Hongjuan <hongjuanx.wang@intel.com>
* Li, Hao <haox.li@intel.com>

## LICENSE

Copyright (c) 2013 Intel Corporation.
Except as noted, this software is licensed under BSD-3-Clause License.
Please see the COPYING file for the BSD-3-Clause License.


