package com.juzi.oerp.controller.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzi.oerp.common.store.LocalUserStore;
import com.juzi.oerp.model.dto.param.PageParamDTO;
import com.juzi.oerp.model.dto.param.UpdateUserInfoParamDTO;
import com.juzi.oerp.model.po.UserInfoPO;
import com.juzi.oerp.model.po.UserPO;
import com.juzi.oerp.model.vo.UserApplyExamVO;
import com.juzi.oerp.model.vo.UserInfoVO;
import com.juzi.oerp.model.vo.response.ResponseVO;
import com.juzi.oerp.model.vo.response.UpdatedResponseVO;
import com.juzi.oerp.service.UserInfoService;
import com.juzi.oerp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juzi
 * @date 2020/7/19 20:48
 */
@Api(tags = "个人中心")
@RequestMapping("/user")
@RestController("userUserController")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "获取个人信息", notes = "获取当前已登录用户的个人信息")
    public ResponseVO<UserInfoVO> getUserInfo() {
        Integer userId = LocalUserStore.getLocalUser();
        UserPO userPO = userService.getById(userId);
        UserInfoVO userInfoVO = userInfoService.getUserInfoAll(userPO);
        return new ResponseVO<>(userInfoVO);
    }

    @PutMapping
    @ApiOperation("修改个人信息")
    public UpdatedResponseVO updateUserInfo(@RequestBody @Validated UpdateUserInfoParamDTO updateUserInfoParamDTO) {
        Integer userId = LocalUserStore.getLocalUser();
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setUserId(userId);
        BeanUtils.copyProperties(updateUserInfoParamDTO, userInfoPO);

        userInfoService.updateById(userInfoPO);
        return new UpdatedResponseVO();
    }

    @GetMapping("/apply")
    @ApiOperation("获取报名信息")
    public ResponseVO<Page<UserApplyExamVO>> getUserApplyExam(@Validated PageParamDTO pageParamDTO) {
        Page<UserApplyExamVO> result = userInfoService.queryUserApplyExam(pageParamDTO);
        return new ResponseVO<>(result);
    }
}
