import { Kafka } from "kafkajs";
const kafka=new Kafka({
clientId: 'schedule-service',
brokers: ['localhost:9092'],
});

const producer=kafka.producer();
// added event schedule object
const publish =async(EventSchedule)=> {
    await producer
    .connect().catch((e)=> console.error('error on connecting kafka',e));

  
 await producer.send({
    topic:'new_order_response',
    messages:[
      //   {key:i.toString(),value:JSON.stringify({empName:'Kalpa '+i})},
       {EventSchedule},
    ],
 });
    
};
publish().catch((e)=>console.error(e));
export default publish;