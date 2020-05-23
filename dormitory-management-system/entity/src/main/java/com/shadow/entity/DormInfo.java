package com.shadow.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author WCZ
 * @date 2020-05-18
 * @Description:
 **/
@Data
@Table(name = "dorm_info")
public class DormInfo {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "dormitory_id")
    private String dormitoryId;

    @Column(name = "member")
    private int member;

    @Column(name = "reward_times")
    private int rewardTimes;

    @Column(name = "criticism_times")
    private int criticismTimes;

    @Column(name = "score")
    private int score;

    @Column(name = "hygiene_score")
    private int hygieneScore;
}
