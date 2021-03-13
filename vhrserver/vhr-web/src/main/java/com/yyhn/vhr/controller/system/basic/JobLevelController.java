package com.yyhn.vhr.controller.system.basic;

import com.yyhn.vhr.model.JObLevel;
import com.yyhn.vhr.model.RespBean;
import com.yyhn.vhr.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/job")
public class JobLevelController {
    @Autowired
    JobService jobService;

    @GetMapping("/")
    public List<JObLevel> getJobLevelList() {
        return jobService.getJobLevelList();
    }

    @PostMapping("/")
    public RespBean addJob(@RequestBody JObLevel jObLevel) {
        if (jobService.addJob(jObLevel) > 0) {
            return RespBean.ok("新增成功");
        } else {
            return RespBean.error("新增失败");
        }
    }

    @DeleteMapping("/{id}")
    public RespBean delJob(@PathVariable Integer id) {
        if (jobService.delJob(id) > 0) {
            return RespBean.ok("删除成功");
        } else {
            return RespBean.error("删除失败");
        }
    }

    @PutMapping("/")
    public RespBean updateJob(@RequestBody JObLevel jObLevel) {
        if (jobService.updateJob(jObLevel) > 0) {
            return RespBean.ok("修改成功");
        } else {
            return RespBean.error("修改失败");
        }
    }
}
