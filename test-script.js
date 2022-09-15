import http from "k6/http";
import { check, group, sleep } from "k6";
import { Rate } from "k6/metrics"
var vuLocalCounter = 1;

export let options = {
    vus: 10,
    stages: [
        { duration: "1m", target: 20 },
        { duration: "3m", target: 30 },
        { duration: "4m", target: 40 },
        { duration: "1m", target: 20 }
    ]
};

export default function() {
	let json =  {
              "code": vuLocalCounter,
              "items": [
                {
                  "id": 3,
                  "product": {
                    "id": 1,
                    "name": "Mouse"
                  },
                  "quantity": 1,
                  "price": 59.6
                }
              ]
            };
    let response = http.post("http://localhost:8080/v1/orders", JSON.stringify(json), { headers: { 'Content-Type': 'application/json' } });
    //console.log(response);
	let checkRes = check(response, {
		"status is 201": (r) => r.status === 201
	});

	let get = http.get("http://localhost:8080/v1/orders/"+ vuLocalCounter);
	check(get, {
    		"status is 200": (r) => r.status === 200
    	});
	//console.log(get);
	vuLocalCounter++;
};
