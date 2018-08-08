package com.example.distance.weibo.Model;

import java.io.Serializable;


/**
 * Created by hantiaotiao on 2018/8/6.
 * Focus的复合主键类
 *
 * @Param userId
 * @Param VID
 * 由这两个个共同组成复合主键
 */
public class FocusMultiKey implements Serializable {

    private Integer userId;
    private Integer VId;

    //  ***重写hashCode与equals方法***

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((userId == null) ? 0 : userId.hashCode());
        result = PRIME * result + ((VId == null) ? 0 : VId.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        final FocusMultiKey other = (FocusMultiKey) obj;
        if(userId == null){
            if(other.userId != null){
                return false;
            }
        }else if(!userId.equals(other.userId)){
            return false;
        }
        if(VId == null){
            if(other.VId != null){
                return false;
            }
        }else if(!VId.equals(other.VId)){
            return false;
        }
        return true;
    }

    public FocusMultiKey() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVId() {
        return VId;
    }

    public void setVId(Integer VId) {
        this.VId = VId;
    }
}
