/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/11/10 22:59:39                          */
/*==============================================================*/
drop database if exists simmya;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`simmya` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `simmya`;

drop table if exists ADDRESS;

drop table if exists BACK_BOX;

drop table if exists BACK_ORDER;

drop table if exists BOX;

drop table if exists BOX_COLLECTION;

drop table if exists BOX_INFO_REF;

drop table if exists CARTS;

drop table if exists DISCUSS;

drop table if exists INFO;

drop table if exists INFO_AGREE;

drop table if exists INFO_COLLECTION;

drop table if exists ORDERS;

drop table if exists ORDER_BOX_REF;

drop table if exists SERVERS;

drop table if exists USER;

drop table if exists VAL_SET;

drop table if exists USER_SHARE_REF;



drop table if exists CODEC;

/*==============================================================*/
/* Table: CODEC                                                 */
/*==============================================================*/
create table CODEC
(
   ID                   varchar(32) comment 'id',
   VERI_CODE            varchar(8) comment '短信验证码',
   EXPIRED_TIME         datetime comment '过期时间',
   PHONE                varchar(15) comment '手机号'
);

alter table CODEC comment '短信验证表';


/*==============================================================*/
/* Table: ADDRESS                                               */
/*==============================================================*/
create table ADDRESS
(
   ID                   varchar(32) not null comment 'id',
   ADDRESS_INFO         varchar(600) comment '地址名称',
   ZIPCODE              varchar(10) comment '邮编',
   GET_NAME             varchar(18) comment '收货人姓名',
   PHONE                varchar(15) comment '手机号',
   USER_ID              varchar(32) comment '用户ID',
   primary key (ID)
);

alter table ADDRESS comment '地址表';

/*==============================================================*/
/* Table: BACK_BOX                                              */
/*==============================================================*/
create table BACK_BOX
(
   ID                   varchar(32) not null comment 'ID',
   USER_ID              varchar(32) comment 'user_id',
   ORDER_ID             varchar(32) comment 'ORDER_ID',
   BOX_ID               varchar(32) comment 'BOX_ID',
   CREATE_TIME          datetime comment 'CREATE_TIME',
   primary key (ID)
);

alter table BACK_BOX comment '退货表';

/*==============================================================*/
/* Table: BACK_ORDER                                            */
/*==============================================================*/
create table BACK_ORDER
(
   ID                   varchar(32) not null comment 'ID',
   ORDERS_ID            varchar(32) comment '订单ID',
   USER_ID              varchar(32) comment 'USER_ID',
   CREATE_TIME          datetime comment 'CREATE_TIME',
   primary key (ID)
);

alter table BACK_ORDER comment '退订表';

/*==============================================================*/
/* Table: BOX                                                   */
/*==============================================================*/
create table BOX
(
   ID                   varchar(32) not null comment 'id',
   NAME                 varchar(60) comment '名称',
   TITLE                varchar(150) comment '摘要',
   DETAIL               varchar(450) comment '介绍',
   IMAGE_ADDRESS        varchar(200) comment '图片地址',
   BOX_PRICE            decimal(10,2) comment '价格',
   COLLECT_COUNT        int comment '收藏数',
   SHARE_COUNT          int comment '分享数',
   primary key (ID)
);

alter table BOX comment '盒子表';

/*==============================================================*/
/* Table: BOX_COLLECTION                                        */
/*==============================================================*/
create table BOX_COLLECTION
(
   ID                   varchar(32) not null comment 'id',
   USER_ID              varchar(32) comment '用户ID',
   BOX_ID               varchar(32) comment '盒子ID',
   primary key (ID)
);

alter table BOX_COLLECTION comment '我的盒子收藏';


/*==============================================================*/
/* Table: BOX_INFO_REF                                          */
/*==============================================================*/
create table BOX_INFO_REF
(
   ID                   varchar(32) not null comment 'id',
   BOX_ID               varchar(32) comment 'BOX_ID',
   INFO_ID              varchar(32) comment 'INFO_ID',
   primary key (ID)
);


/*==============================================================*/
/* Table: CARTS                                                 */
/*==============================================================*/
create table CARTS
(
   ID                   varchar(32) not null comment 'id',
   USER_ID              varchar(32) comment 'USER_ID',
   BOX_IDS              varchar(1000) comment 'BOX_IDS',
   primary key (ID)
);

alter table CARTS comment '购物车';

/*==============================================================*/
/* Table: DISCUSS                                               */
/*==============================================================*/
create table DISCUSS
(
   ID                   varchar(32) not null comment 'id',
   INFO_ID              varchar(32) comment '资讯ID',
   CONTENT              varchar(600) comment '评论内容',
   CREATE_TIME          datetime comment 'CREATE_TIME',
   USER_ID              varchar(32) comment '用户ID',
   primary key (ID)
);

alter table DISCUSS comment '资讯评论表';

/*==============================================================*/
/* Table: INFO                                                  */
/*==============================================================*/
create table INFO
(
   ID                   varchar(32) not null comment 'id',
   NAME                 varchar(60) comment '标题',
   TITLE                varchar(150) comment '摘要',
   DETAIL               varchar(450) comment '详细内容',
   COLLECT_COUNT        int comment '收藏数',
   SHARE_COUNT          int comment '分享数',
   AGREE_COUNT          int comment '赞数',
  -- DISCUSS_ID           varchar(32) comment '评论ID',
   IMAGE_ADDRESS        varchar(200) comment '图片地址',
   SOURCE               varchar(300) comment '资讯出处',
   CLICK_COUNT          int comment '点击数',
   DISCUSS_COUNT        int comment '评论数',
   primary key (ID)
);

alter table INFO comment '资讯表';

/*==============================================================*/
/* Table: INFO_AGREE                                            */
/*==============================================================*/
create table INFO_AGREE
(
   ID                   varchar(32) not null comment 'id',
   USER_ID              varchar(32) comment '用户ID',
   INFO_ID              varchar(32) comment '资讯ID',
   primary key (ID)
);

alter table INFO_AGREE comment '我的资讯点赞';

/*==============================================================*/
/* Table: INFO_COLLECTION                                       */
/*==============================================================*/
create table INFO_COLLECTION
(
   ID                   varchar(32) not null comment 'id',
   USER_ID              varchar(32) comment '用户ID',
   INFO_ID              varchar(32) comment '资讯ID',
   primary key (ID)
);

alter table INFO_COLLECTION comment '我的资讯收藏';

/*==============================================================*/
/* Table: ORDERS                                                */
/*==============================================================*/
create table ORDERS
(
   ID                   varchar(32) not null comment 'ID',
   USER_ID              varchar(32) comment 'USER_ID',
   STATUS               varchar(30) comment '状态',
   TOTAL_PRICE          decimal(10,2) comment '总额',
   CREATE_TIME          datetime comment 'CREATE_TIME',
   ADDRESS_ID           varchar(32) comment 'ADDRESS_ID',
   primary key (ID)
);

alter table ORDERS comment '订单表';

/*==============================================================*/
/* Table: ORDER_BOX_REF                                         */
/*==============================================================*/
create table ORDER_BOX_REF
(
   ID                   varchar(32) not null comment 'id',
   ORDER_ID             varchar(32) comment 'ORDER_ID',
   BOX_ID               varchar(32) comment 'BOX_ID',
   ORDER_COUNT          int comment '订阅期限',
   ORDER_WAY            varchar(15) comment '投递方式',
   STATUS               varchar(30) comment '完成状态',
   SEND_COUNT           int comment '已发送次数',
   UPDATE_TIME          datetime comment '最后一次发送时间',
   primary key (ID)
);

alter table ORDER_BOX_REF comment '订单盒子中间表';

/*==============================================================*/
/* Table: SERVERS                                               */
/*==============================================================*/
create table SERVERS
(
   ID                   varchar(32) not null comment 'id',
   QQ                   varchar(20) comment 'QQ',
   WEIXIN               varchar(30) comment '微信号',
   PHONE                varchar(20) comment '电话',
   USERNAME             varchar(30) comment '姓名',
   NICKNAME             varchar(45) comment '昵称',
   primary key (ID)
);

alter table SERVERS comment '客服表';

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
create table USER
(
   ID                   varchar(32) not null comment 'id',
   USERNAME             varchar(60) comment '用户名(手机号)',
   PASSWORD             varchar(60) comment '密码',
   NICKNAME             varchar(60) comment '昵称',
   GENDER               varchar(4) comment '性别',
   BIRTH                datetime comment '出生',
   ZODIAC               varchar(10) comment '生肖',
   PROFESSION           varchar(60) comment '职业',
   VERI_CODE            varchar(18) comment '短信验证码',
   TOKEN            varchar(32) comment '登录时token',
   BALANCE              decimal(10,2) comment '余额',
   EXPIRED_TIME         datetime comment '验证码过期时间',
   HEAD_PIC             varchar(200) comment '我的头像',
   primary key (ID)
);

alter table USER comment '用户表';

/*==============================================================*/
/* Table: VAL_SET                                               */
/*==============================================================*/
create table VAL_SET
(
   ID                   varchar(32) not null comment 'ID',
   KEY_                 varchar(50) comment 'KEY_',
   VALUE_               varchar(100) comment 'VALUE_',
   primary key (ID)
);

alter table VAL_SET comment '参数设置表,设置分享一条资讯获得多少信用额';


/*==============================================================*/
/* Table: USER_SHARE_REF                                        */
/*==============================================================*/
create table USER_SHARE_REF
(
   ID                   varchar(32) not null comment 'id',
   USER_ID              varchar(32) comment 'USER_ID',
   INFO_ID              varchar(32) comment 'INFO_ID',
   primary key (ID)
);

alter table USER_SHARE_REF comment '用户_资讯分享关系表';


/*========================== 初始化数据 =========================================*/

insert into user values('1','user1','password','uu1','男','1987-01-01','兔','程序员','验证码','token1',100,'2015-11-11','头像');
insert into user values('2','user2','password','uu2','女','1988-01-01','龙','程序员','验证码','token2',200,'2015-11-11','头像');
insert into user values('3','user3','password','uu3','女','1989-01-01','蛇','程序员','验证码','token3',300,'2015-11-11','头像');

insert into info values('1','咨询1','主题1','详情1',0,0,0,'图片地址1','咨询出处1',1,0);
insert into info values('2','咨询2','主题2','详情2',0,0,0,'图片地址2','咨询出处2',2,0);
insert into info values('3','咨询3','主题3','详情3',0,0,0,'图片地址3','咨询出处3',3,0);
insert into info values('4','咨询4','主题4','详情4',0,0,0,'图片地址4','咨询出处4',4,0);
insert into info values('5','咨询5','主题5','详情5',0,0,0,'图片地址5','咨询出处5',5,0);
insert into info values('6','咨询6','主题6','详情6',0,0,0,'图片地址6','咨询出处6',6,0);
insert into info values('7','咨询7','主题7','详情7',0,0,0,'图片地址7','咨询出处7',7,0);
insert into info values('8','咨询8','主题8','详情8',0,0,0,'图片地址8','咨询出处8',8,0);
insert into info values('9','咨询9','主题9','详情9',0,0,0,'图片地址9','咨询出处9',9,0);
insert into info values('10','咨询10','主题10','详情10',0,0,0,'图片地址10','咨询出处10',10,0);
insert into info values('11','咨询11','主题11','详情11',0,0,0,'图片地址11','咨询出处11',11,0);

INSERT INTO box VALUES('1','盒子1','主题1','详情1','图片地址1',100,0,0);
INSERT INTO box VALUES('2','盒子2','主题2','详情2','图片地址2',100,0,0);
INSERT INTO box VALUES('3','盒子3','主题3','详情3','图片地址3',100,0,0);

INSERT INTO address VALUES('1','用户1地址1','邮编','收货人地址','电话',1);
INSERT INTO address VALUES('2','用户1地址2','邮编','收货人地址','电话',1);
INSERT INTO address VALUES('3','用户2地址1','邮编','收货人地址','电话',2);
