import emitter from '@ohos.events.emitter';
const utsEmitter = ()=>{
    let data: emitter.EventData = {
        data: {
            "data": "yuhe"
        }
    };
    emitter.emit('launch', data);
    emitter.emit('message', data);
};
export { utsEmitter as utsEmitter };
