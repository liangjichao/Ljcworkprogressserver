#!/bin/bash

SLEEP_INTERVAL=3
MAX_TRY_TIMES=3
COUNT=0

function is_running(){

    if ps -ef |grep WpsServerApplication |grep -v grep >/dev/null 2>&1;then
        echo "Wps process is running"
        return 0
    else
        echo "Wps process is not running"
        return 1
    fi

}


while [ $COUNT -lt $MAX_TRY_TIMES ];
do
  if is_running; then
    echo "Wps prepare stop process"

    ps -ef |grep WpsServerApplication |grep -v grep |awk '{print $2}' |xargs kill >/dev/null 2>&1

    echo "sleep $SLEEP_INTERVAL seconds ..."
    sleep $SLEEP_INTERVAL
    COUNT=$((COUNT + 1))
    echo try $COUNT times
  else
    echo "Wps process  is STOPPED"
    exit 0
  fi
done

# check kill -9

if is_running;then

  ps -ef |grep WpsServerApplication |grep -v grep |awk '{print $2}' |xargs kill -9 >/dev/null 2>&1

  sleep 2

  if is_running;then
    echo "Wps stop failed"
    exit 1
  fi

  exit 0
fi
