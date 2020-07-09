package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger  = new AtomicInteger(0);


    public final int getAndIncrement(){
        int current;
        int next;

        do {
            current = atomicInteger.get();

           next = current >= 10000 ? current = 0 : current + 1;

        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("***next:"+next);
        System.out.println("***atomic:"+atomicInteger.get());

        return next;
    }

    @Override
    public ServiceInstance instance( List<ServiceInstance> serviceInstances ) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
