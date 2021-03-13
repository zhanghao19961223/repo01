package com.yyhn.vhr.controller.system.basic;

import com.yyhn.vhr.model.Position;
import com.yyhn.vhr.model.RespBean;
import com.yyhn.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public List<Position> getPositionList(){
        return positionService.getPositionList();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        if(positionService.addPosition(position)>0){
            return RespBean.ok("添加成功");
        }else{
            return RespBean.error("添加失败");
        }
    }

    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        if(positionService.updatePosition(position)>0){
            return RespBean.ok("修改成功");
        }else{
            return RespBean.error("修改成功");
        }
    }

    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id){
        if(positionService.deletePosition(id)>0){
            return RespBean.ok("删除成功");
        }else{
            return RespBean.error("删除成功");
        }
    }

    @DeleteMapping("/delPos")
    public RespBean deletePositionsByIds(Integer[] ids){
        if(positionService.deletePositionsByIds(ids)<0){
            return RespBean.ok("删除成功");
        }else{
            return RespBean.error("删除成功");
        }
    }
}
