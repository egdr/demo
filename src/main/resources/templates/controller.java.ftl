package ${package.Controller};

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.core.res.Result;
import com.example.demo.core.res.ResultGenerator;
import com.example.demo.test.entity.${entity};
import com.example.demo.test.service.${table.serviceName};

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${table.entityPath}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
     @Resource
     ${table.serviceName} ${table.entityPath}Service;

     @PostMapping("/add${entity}")
     public Result add${entity}(@RequestBody ${entity} ${table.entityPath}) {
     ${table.entityPath}Service.save(${table.entityPath});
     return ResultGenerator.genSuccessResult();
     }

     @PostMapping("/get${entity}")
     public Result get${entity}(@RequestBody ${entity} ${table.entityPath}) {
     User byId = ${table.entityPath}Service.getById(${table.entityPath}.getId());
     return ResultGenerator.genSuccessResult(byId);
     }

     @PostMapping("/update${entity}")
     public Result update${entity}(@RequestBody ${entity} ${table.entityPath}) {
     ${table.entityPath}Service.saveOrUpdate(${table.entityPath});
     return ResultGenerator.genSuccessResult();
     }

     @PostMapping("/get${entity}List")
     public Result get${entity}List(@RequestBody ${entity} ${table.entityPath}) {
     Page page = new Page(1, 20);
     IPage iPage = ${table.entityPath}Service.page(page, Wrappers.query(${table.entityPath}));
     return ResultGenerator.genSuccessResult(iPage);
     }
}
</#if>
