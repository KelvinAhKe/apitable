/*
 * APITable <https://github.com/apitable/apitable>
 * Copyright (C) 2022 APITable Ltd. <https://apitable.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.apitable.user.vo;

import static com.apitable.shared.constants.DateFormatConstants.TIME_SIMPLE_PATTERN;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.apitable.shared.cache.bean.LoginUserDto;
import com.apitable.shared.cache.bean.UserLinkInfo;
import com.apitable.shared.support.serializer.ImageSerializer;
import com.apitable.shared.support.serializer.NullArraySerializer;
import com.apitable.shared.support.serializer.NullBooleanSerializer;
import com.apitable.shared.support.serializer.NullJsonObjectSerializer;
import com.apitable.shared.support.serializer.NullNumberSerializer;
import com.apitable.shared.support.serializer.NullStringSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Account Information View.
 * </p>
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Account Information View")
public class UserInfoVo implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 6771376557632188356L;

    /**
     * user id.
     */
    @ApiModelProperty(value = "User ID (the actual return is uuid)",
        dataType = "java.lang.String", example = "1")
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    private String userId;

    /**
     * uuid.
     */
    @ApiModelProperty(value = "User UUID", example = "1261273764218")
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    private String uuid;

    /**
     * nickName.
     */
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    @ApiModelProperty(value = "Nickname", example = "Zhang San")
    private String nickName;

    /**
     * area code.
     */
    @ApiModelProperty(value = "Mobile phone area code", example = "+1")
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    private String areaCode;

    /**
     * mobile phone number.
     */
    @ApiModelProperty(value = "Phone number", example = "\"13344445555\"")
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    private String mobile;

    /**
     * email.
     */
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    @ApiModelProperty(value = "Email", example = "admin@apitable.com")
    private String email;

    /**
     * user avtar.
     */
    @JsonSerialize(nullsUsing = NullStringSerializer.class, using =
        ImageSerializer.class)
    @ApiModelProperty(value = "Avatar", example = "null")
    private String avatar;

    /**
     * sign up time.
     */
    @ApiModelProperty(value = "Registration time", example = "2019-01-01 "
        + "10:12:13")
    @JsonFormat(pattern = TIME_SIMPLE_PATTERN)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime signUpTime;

    /**
     * last login time.
     */
    @ApiModelProperty(value = "Last logon time", example = "2019-01-01 "
        + "10:12:13")
    @JsonFormat(pattern = TIME_SIMPLE_PATTERN)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime lastLoginTime;

    /**
     * third Party Information.
     */
    @ApiModelProperty(value = "Bind third-party information")
    @JsonSerialize(nullsUsing = NullArraySerializer.class)
    private List<UserLinkVo> thirdPartyInformation;

    /**
     * is need password.
     */
    @ApiModelProperty(value = "Whether to set a password is required. It "
        + "indicates that the user does not have a password. It is a standard"
        + " field for initialization and password setting", example = "false")
    private Boolean needPwd;

    /**
     * is need create.
     */
    @Builder.Default
    @ApiModelProperty(value = "Whether it is necessary to create a space "
        + "indicates that the user does not have any space association, which"
        + " is a standard field for space creation guidance", example =
        "false")
    private Boolean needCreate = true;

    /**
     * space id.
     */
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    @ApiModelProperty(value = "Space id", example = "spcx2yLGGedWc")
    private String spaceId;

    /**
     * space name.
     */
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    @ApiModelProperty(value = "Space name", example = "My Workspace")
    private String spaceName;

    /**
     * space logo.
     */
    @JsonSerialize(nullsUsing = NullStringSerializer.class, using =
        ImageSerializer.class)
    @ApiModelProperty(value = "Space logo", example = "http://...")
    private String spaceLogo;

    /**
     * member id.
     */
    @JsonSerialize(using = ToStringSerializer.class, nullsUsing =
        NullStringSerializer.class)
    @ApiModelProperty(value = "Member ID corresponding to the space")
    private Long memberId;

    /**
     * member name.
     */
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    @ApiModelProperty(value = "Member name corresponding to the space")
    private String memberName;

    /**
     * unit id.
     */
    @JsonSerialize(using = ToStringSerializer.class, nullsUsing =
        NullStringSerializer.class)
    @ApiModelProperty(value = "Organization unit ID of the corresponding "
        + "member of the space")
    private Long unitId;

    /**
     * active node id.
     */
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    @ApiModelProperty(value = "ID of the open data table node in the space",
        example = "dst151d")
    private String activeNodeId;

    /**
     * active view id.
     */
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    @ApiModelProperty(value = "ID of the view opened in the meter", example =
        "views135")
    private String activeViewId;

    /**
     * active node location.
     */
    @ApiModelProperty(value = "Active node location (0: working directory; 1:"
        + " star)")
    @JsonSerialize(nullsUsing = NullNumberSerializer.class)
    private Integer activeNodePos;

    /**
     * is admin.
     */
    @Builder.Default
    @ApiModelProperty(value = "Whether it is a space administrator, and "
        + "whether the space management menu is displayed", example = "false")
    private Boolean isAdmin = false;

    /**
     * is main admin.
     */
    @Builder.Default
    @ApiModelProperty(value = "Primary administrator or not", example =
        "false")
    private Boolean isMainAdmin = false;

    /**
     * is paused.
     */
    @Builder.Default
    @JsonSerialize(nullsUsing = NullBooleanSerializer.class)
    @ApiModelProperty(value = "Whether the account is cancelled during the "
        + "cooling off period (account recovery is allowed during the cooling"
        + " off period)", example = "false")
    private Boolean isPaused = false;

    /**
     * close time.
     */
    @ApiModelProperty(value = "Account destruction time", example = "2022-01"
        + "-03 00:00:00")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = TIME_SIMPLE_PATTERN)
    private LocalDateTime closeAt;

    /**
     * is deleted space.
     */
    @Builder.Default
    @ApiModelProperty(value = "Whether the space is deleted", example =
        "false")
    private Boolean isDelSpace = false;

    /**
     * api key.
     */
    @JsonSerialize(nullsUsing = NullStringSerializer.class)
    @ApiModelProperty(value = "Developer Access Token", example =
        "uskPtGBUw8EuVKoo3X6")
    private String apiKey;

    /**
     * wizards.
     */
    @ApiModelProperty(value = "Boot related status values", example = "{\"1"
        + "\":1, \"3\":5}")
    @JsonSerialize(nullsUsing = NullJsonObjectSerializer.class)
    private JSONObject wizards;

    /**
     * invite code.
     */
    @ApiModelProperty(value = "Personal invitation code", example = "test")
    private String inviteCode;

    /**
     * space domain.
     */
    @ApiModelProperty(value = "Space station domain name")
    private String spaceDomain;

    /**
     * is name modified.
     */
    @ApiModelProperty(value = "Whether the user's space has changed the "
        + "internal nickname (abandoned)")
    private Boolean isNameModified;

    /**
     * is newComer.
     */
    @ApiModelProperty(value = "Whether the user is new")
    private Boolean isNewComer;

    /**
     * is nickName modified.
     */
    @ApiModelProperty(value = "(Used in WeCom)Whether the user has modified "
        + "the nickname")
    private Boolean isNickNameModified;

    /**
     * ismMemberName modified.
     */
    @ApiModelProperty(value = "(Used in WeCom)Whether the member has modified"
        + " the nickname")
    private Boolean isMemberNameModified;

    /**
     * send subscription notify.
     */
    @ApiModelProperty(value = "Whether to send subscription related "
        + "notifications", notes = "Read「ConstProperties」Value of profile")
    private Boolean sendSubscriptionNotify;

    /**
     * used invite reward.
     */
    @ApiModelProperty(value = "Have you ever used invitation rewards", notes
        = "Identify whether invitation rewards have been used")
    @JsonSerialize(nullsUsing = NullBooleanSerializer.class)
    private Boolean usedInviteReward;

    /**
     * user avatar color.
     */
    @ApiModelProperty(value = "default avatar color number")
    private Integer avatarColor;

    /**
     * user time zone.
     */
    @ApiModelProperty(value = "user time zone", example = "UTC-5"
        + "(America/Toronto)")
    private String timeZone;

    /**
     * Transfer data from loginUserDto.
     *
     * @param loginUserDto LoginUserDto
     */
    public void transferDataFromLoginUserDto(final LoginUserDto loginUserDto) {
        this.setUserId(loginUserDto.getUuid());
        this.setUuid(loginUserDto.getUuid());
        this.setNickName(loginUserDto.getNickName());
        this.setAreaCode(loginUserDto.getAreaCode());
        this.setMobile(loginUserDto.getMobile());
        this.setEmail(loginUserDto.getEmail());
        this.setAvatar(loginUserDto.getAvatar());
        this.setAvatarColor(loginUserDto.getColor());
        this.setTimeZone(loginUserDto.getTimeZone());
        this.setNeedPwd(loginUserDto.getNeedPwd());
        this.setSignUpTime(loginUserDto.getSignUpTime());
        this.setLastLoginTime(loginUserDto.getLastLoginTime());
        this.setIsPaused(loginUserDto.getIsPaused());
        this.setIsNickNameModified(loginUserDto.getIsNickNameModified());
    }

    /**
     * Transfer data from dto.
     *
     * @param userLinkInfo UserLinkInfo
     * @param userLinkVos UserLinkVo list
     */
    public void transferDataFromDto(final UserLinkInfo userLinkInfo,
        final List<UserLinkVo> userLinkVos) {
        this.setWizards(JSONUtil.parseObj(userLinkInfo.getWizards()));
        this.setThirdPartyInformation(userLinkVos);
        this.setInviteCode(userLinkInfo.getInviteCode());
        this.setApiKey(userLinkInfo.getApiKey());
    }
}
