package com.juzi.oerp.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author Juzi
 * @since 2020-07-14
 */
@Data
@TableName("user_info")
@Accessors(chain = true)
@ApiModel(description = "用户信息")
public class UserInfoPO {

    @TableId(value = "user_id", type = IdType.NONE)
    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("头像")
    private String avatarUrl;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别：0未知/1男/2女")
    private Integer gender;

    @ApiModelProperty("证件照")
    private String photoUrl;

    @ApiModelProperty("身份证号码")
    private String identityNo;

    @ApiModelProperty("学校")
    private String school;

    @ApiModelProperty("学历")
    private String education;

    @ApiModelProperty("生日")
    private LocalDateTime birthday;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

}
