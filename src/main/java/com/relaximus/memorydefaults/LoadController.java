package com.relaximus.memorydefaults;

import com.martensigwart.fakeload.FakeLoad;
import com.martensigwart.fakeload.FakeLoadExecutor;
import com.martensigwart.fakeload.FakeLoads;
import com.martensigwart.fakeload.MemoryUnit;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoadController {

    @Autowired
    FakeLoadExecutor fakeLoadExecutor;

    @PostMapping("/load/{s}/{m}")
    public void load(@PathVariable int s, @PathVariable int m) {
        FakeLoad fakeLoad = FakeLoads.create()
            .lasting(s, TimeUnit.SECONDS)
            .withMemory(m, MemoryUnit.MB);

        log.info("Loading for {} s with {} Mb mem load.", s, m);
        fakeLoadExecutor.execute(fakeLoad);
        System.gc();
    }
}
