package com.example.distance.weibo.service;

import com.example.distance.utils.result.ErrorResult;
import com.example.distance.utils.result.Result;
import com.example.distance.utils.result.SuccessResult;
import com.example.distance.weibo.Model.Weibo;
import com.example.distance.weibo.Model.WeiboPicture;
import com.example.distance.weibo.repository.WeiboPictureRepository;
import com.example.distance.weibo.repository.WeiboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@Service
public class WeiboService {

    @Autowired
    WeiboRepository weiboRepository;

    @Autowired
    WeiboPictureRepository wpRspository;

    public Result createWeibo(Integer userId) {
        Weibo weibo = new Weibo(userId);
        weibo.setUserName(" userName ");
        weiboRepository.save(weibo);
        return new SuccessResult(weibo);
    }


    public Result setContent(Integer userId, Integer weiboId, String content) {
        Weibo weibo = weiboRepository.findOneByWeiboId(weiboId);
        if (weibo == null)
            return new ErrorResult();
        weibo.setContent(content);
        weiboRepository.save(weibo);
        return new SuccessResult(weibo);
    }

    public Result addPic(Integer userId, Integer weiboId, String picPath) {

        WeiboPicture weiboPicture = new WeiboPicture();
        weiboPicture.setPicPath(picPath);
        weiboPicture.setWeiboId(weiboId);
        weiboPicture.setUserId(userId);
        wpRspository.save(weiboPicture);

        return new SuccessResult();
    }

    public Result delPic(Integer userId, Integer weiboId, String picPath) {

        WeiboPicture weiboPicture = wpRspository.findByWeiboIdAndPicPath(weiboId,picPath);
        if (weiboPicture==null)
            return new ErrorResult();
        wpRspository.delete(weiboPicture);
        return new SuccessResult();

    }

    public Result getWeibo(Integer weiboId) {
        Weibo weibo = weiboRepository.findOneByWeiboId(weiboId);
        if (weibo == null)
            return new ErrorResult();
        return new SuccessResult(weibo);
    }

    public Result getAllWeibo() {
        List<Weibo> weibos = weiboRepository.findAll();
        if (weibos == null)
            return new ErrorResult();
        return new SuccessResult(weibos);
    }

    public Result getPictures(Integer weiboId) {
        Iterable<WeiboPicture> ret = wpRspository.findAllByWeiboId(weiboId);
        return new SuccessResult(ret);
    }


}
