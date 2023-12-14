#!/bin/bash
#userdir
SHDIR=$(cd $(dirname $0) ; pwd)
echo current path:$SHDIR

function is_running(){

    if ps -ef |grep WpsServerApplication |grep -v grep >/dev/null 2>&1;then
        echo "Wps process is running"
        return 0
    else
        echo "Wps process is not running"
        return 1
    fi

}

START_JAVA_OPTS="-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/export/Logs -XX:+UseG1GC -Xms2048m -Xmx2048m"

# exec
nohup /export/servers/jdk1.8.0_391/bin/java -DappName=jdl-wps $START_JAVA_OPTS -Xss512k -server -classpath $SHDIR/../conf/:$SHDIR/../lib/* com.jdl.wps.WpsServerApplication &

if is_running;then

    exit 0
else
    echo "Wps start failed"
    exit 1
fi