import { Kafka } from "kafkajs";
import logger from "./logger/logger.js";
//import publish  from './producer.js';

const kafka=new Kafka({
clientId: 'employee-service',
brokers: ['localhost:9092'],
});

const consumer=kafka.consumer({groupId:'finance_group'});
await consumer.subscribe({topic: 'new_order',fromBeginning:true});

await consumer.run({
    eachMessage:async({topic,partition, message})=>{
     
        let value=JSON.parse(message.value)
        let from=value["orderid"];
        if(value["from"]==="Allocation_service" & value["type"]==="complete_allocation" & value["result"]==="Success"){
            logger.info(
                `Allocation type, complete allocation, Success . (${value["result"]}) process completed`);
                var fiveDaysLater=new Date();
                fiveDaysLater.setDate(fiveDaysLater.getDate()+5);

                const year=fiveDaysLater.getFullYear();
                const month = ("0" + (fiveDaysLater.getMonth() + 1)).slice(-2);
                const day = ("0" + fiveDaysLater.getDate()).slice(-2);

                const hour = ("0" + fiveDaysLater.getHours()).slice(-2);
                const minute = ("0" + fiveDaysLater.getMinutes()).slice(-2);
                const second = ("0" + fiveDaysLater.getSeconds()).slice(-2);

                const formattedDate = `${day}-${month}-${year}`;
                const formattedTime= `${hour}:${minute}:${second}`;
             
                const EventSchedule={
                    from:'schedule_service',
                    type:'complete_schedule',
                    key:value["key"],
                    qty:value["qty"],
                    orderid:value["orderid"],
                    stockid:value["stockid"],
                    result:'Success',
                    date:formattedDate,
                    time:formattedTime
                }

           const event=JSON.stringify(EventSchedule);
           console.log(event);
           console.log(EventSchedule);
           //await publish();


           const producer=kafka.producer();
// added event schedule object
      const publish =async()=> {

      console.log("call function");
      await producer
      .connect().catch((e)=> console.error('error on connecting kafka',e));

  
   

       await producer.send({
        topic: 'schedule-response',
        messages: [
          { value: event },
        ],
      })


 console.log("response sent");
};
publish().catch((e)=>console.error(e));


        }else{
            logger.info(
                `incomming message is not from allocation type. (${value["from"]}) skipped the process`);
        }


    },
});