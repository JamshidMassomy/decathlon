xargs -I % -P 10 curl -X GET "http://localhost:8080/api/v1/calculate-points?sport=LONG_JUMP&result=7.76" -H "accept: */*" -H "Content-Type: application/json"  < <(printf '%s\n' {1..10})