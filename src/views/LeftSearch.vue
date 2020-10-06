<template>
  <div>

    <!--话题、帖子、用户分栏-->
    <div class="main-font">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="话题" name="first">
          <div>
            <el-card class="main-font" v-for="(item,index) in topics" :key="index" style="margin-top: 30px">
              <el-container>
                <el-aside width="20%">
                  <div>
                    <img style=""
                         :src="item.headImg"
                         alt="">
                  </div>
                </el-aside>
                <el-container>
                  <el-header><span style="color: cornflowerblue;font-size: larger">{{ item.name }}</span> <span
                      style="color: #42b983">{{ item.introduction }}</span></el-header>
                  <el-main>
                    <span style="color: blue;font-size: large">{{ item.userCount }}</span>
                  </el-main>
                </el-container>
              </el-container>
            </el-card>
          </div>
        </el-tab-pane>
        <el-tab-pane label="帖子" name="second">
          <el-card class="box-card main-font" style="margin-top: 20px;width: 80%" v-for="(item ,index) in user"
                   :key="index">
            <!--头像 用户名-->
            <div class="flex_center">
              <!--            <el-row type="flex" justify="left">-->
              <!--              <el-col :span="16" align="center" >-->
              <div class="head_content_flex">

                <div class="round-icon">
                  <img :src="item.headImg">
                </div>

                <div>
                  <el-alert
                      v-bind:title="item.username"
                      type="success"
                      :closable="false"
                      style="background: white"
                      v-bind:description="item.userIntroduction"
                  >
                  </el-alert>
                </div>
              </div>


              <div class="grid-content bg-purple">
                <el-button round><i class="el-icon-circle-plus-outline"></i>关注</el-button>
              </div>
              <!--              </el-col>-->
              <!--            </el-row>-->
            </div>
            <!--内容-->
            <div>
              <div :body-style="{ padding: '0px' }">
                <div style="padding: 14px;">
                  <span>{{ item.content }}</span>
                </div>
                <el-carousel :interval="5000" arrow="always" style="width: 80%" class="main-font">
                  <el-carousel-item v-for="(item2,index2) in item.imgs" :key="index2">
                    <img :src="item2">
                  </el-carousel-item>
                </el-carousel>
              </div>
            </div>
            <!--标签-->
            <div style="margin-top: 10px">
              <el-tag type="success">{{ item.type.typeName }}</el-tag>
            </div>
            <!--点赞 评论 XX-->
            <div>
              <el-row type="flex" justify="center">
                <el-col :span="3">
                  <el-button icon="el-icon-share">{{ item.share }}</el-button>
                </el-col>
                <el-col :span="3">
                  <el-button icon="el-icon-edit" @click="comment(item.contentId)">{{ item.comment }}</el-button>
                </el-col>
                <el-col :span="5">
                  <el-button icon="el-icon-arrow-up">{{ item.agree }}</el-button>
                  <el-button icon="el-icon-arrow-down"></el-button>
                </el-col>
              </el-row>
            </div>
          </el-card>


        </el-tab-pane>
        <el-tab-pane label="用户" name="third">
          <div class="flex_center">
            <!--            <el-row type="flex" justify="left">-->
            <!--              <el-col :span="16" align="center" >-->
            <div class="head_content_flex">

              <div class="round-icon">
                <img
                    src="https://i.picsum.photos/id/1001/5616/3744.jpg?hmac=38lkvX7tHXmlNbI0HzZbtkJ6_wpWyqvkX4Ty6vYElZE">
              </div>

              <div>
                <el-alert
                    title="带辅助性文字介绍"
                    type="success"
                    :closable="false"
                    style="background: white"
                    description="这是一句绕口令：黑灰化肥会挥发发灰黑化肥挥发；灰黑化肥会挥"
                >
                </el-alert>
              </div>
            </div>


            <div class="grid-content bg-purple">
              <el-button round><i class="el-icon-circle-plus-outline"></i>关注</el-button>
            </div>
            <!--              </el-col>-->
            <!--            </el-row>-->
          </div>
          <div class="flex_center">
            <!--            <el-row type="flex" justify="left">-->
            <!--              <el-col :span="16" align="center" >-->
            <div class="head_content_flex">

              <div class="round-icon">
                <img
                    src="https://i.picsum.photos/id/1001/5616/3744.jpg?hmac=38lkvX7tHXmlNbI0HzZbtkJ6_wpWyqvkX4Ty6vYElZE">
              </div>

              <div>
                <el-alert
                    title="带辅助性文字介绍"
                    type="success"
                    :closable="false"
                    style="background: white"
                    description="这是一句绕口令：黑灰化肥会挥发发灰黑化肥挥发；灰黑化肥会挥"
                >
                </el-alert>
              </div>
            </div>


            <div class="grid-content bg-purple">
              <el-button round><i class="el-icon-circle-plus-outline"></i>关注</el-button>
            </div>
            <!--              </el-col>-->
            <!--            </el-row>-->
          </div>
          <div class="flex_center">
            <!--            <el-row type="flex" justify="left">-->
            <!--              <el-col :span="16" align="center" >-->
            <div class="head_content_flex">

              <div class="round-icon">
                <img
                    src="https://i.picsum.photos/id/1001/5616/3744.jpg?hmac=38lkvX7tHXmlNbI0HzZbtkJ6_wpWyqvkX4Ty6vYElZE">
              </div>

              <div>
                <el-alert
                    title="带辅助性文字介绍"
                    type="success"
                    :closable="false"
                    style="background: white"
                    description="这是一句绕口令：黑灰化肥会挥发发灰黑化肥挥发；灰黑化肥会挥"
                >
                </el-alert>
              </div>
            </div>


            <div class="grid-content bg-purple">
              <el-button round><i class="el-icon-circle-plus-outline"></i>关注</el-button>
            </div>
            <!--              </el-col>-->
            <!--            </el-row>-->
          </div>

        </el-tab-pane>
      </el-tabs>
    </div>


  </div>
</template>

<script>
export default {
  name: "LeftTopic",
  data() {
    return {
      input10: '',
      activeIndex: '3',
      activeName: 'second',
      imgs: [
        "https://i.picsum.photos/id/0/5616/3744.jpg?hmac=3GAAioiQziMGEtLbfrdbcoenXoWAW-zlyEAMkfEdBzQ",
        "https://i.picsum.photos/id/1/5616/3744.jpg?hmac=kKHwwU8s46oNettHKwJ24qOlIAsWN9d2TtsXDoCWWsQ",
        "https://i.picsum.photos/id/10/2500/1667.jpg?hmac=J04WWC_ebchx3WwzbM-Z4_KC_LeLBWr5LZMaAkWkF68",
      ],
      topics: [],
      user: [],
    }
  },
  methods: {
    handleClick(tab, event) {
      // console.log(tab, event);
      let keyword = this.$route.query.keyword
      console.log(keyword)
      console.log(tab.paneName)
      let paneName = tab.paneName
      if (paneName === "first") {
        this.topics = [
          {
            headImg: "https://i.picsum.photos/id/101/2621/1747.jpg?hmac=cu15YGotS0gIYdBbR1he5NtBLZAAY6aIY5AbORRAngs",
            name: "张三是谁",
            userCount: "2000位法外狂徒张三",
            introduction: "简介测试测试aaaa"
          },
          {
            headImg: "https://i.picsum.photos/id/1025/4951/3301.jpg?hmac=_aGh5AtoOChip_iaMo8ZvvytfEojcgqbCH7dzaz-H8Y",
            name: "正义天使李四",
            userCount: "2000位正义天使张三",
            introduction: "简介测试测试aaaa"

          },
          {
            headImg: "https://i.picsum.photos/id/1023/3955/2094.jpg?hmac=AW_7mARdoPWuI7sr6SG8t-2fScyyewuNscwMWtQRawU",
            name: "测试测试测试",
            userCount: "测试测测内容",
            introduction: "简介测试测试ccc"
          },
        ]
      } else if (paneName === "second") {
        this.user = [
          {
            contentId: 3,
            username: "张三",
            headImg: "https://i.picsum.photos/id/1005/5760/3840.jpg?hmac=2acSJCOwz9q_dKtDZdSB-OIK1HUcwBeXco_RMMTUgfY",
            userIntroduction: "张三是个好人",
            content: "我要个性网的头像大全频道,您可以发布、寻找各种男生女生头像、情侣头像、带字等个性的QQ头像。",
            imgs: [
              "https://i.picsum.photos/id/0/5616/3744.jpg?hmac=3GAAioiQziMGEtLbfrdbcoenXoWAW-zlyEAMkfEdBzQ",
              "https://i.picsum.photos/id/1/5616/3744.jpg?hmac=kKHwwU8s46oNettHKwJ24qOlIAsWN9d2TtsXDoCWWsQ",
              "https://i.picsum.photos/id/10/2500/1667.jpg?hmac=J04WWC_ebchx3WwzbM-Z4_KC_LeLBWr5LZMaAkWkF68",
            ],
            type: {
              typeId: 1,
              typeName: "张三是谁"
            },
            share: 233,
            comment: 666,
            agree: 123

          },
          {
            contentId: 1,
            username: "李四",
            headImg: "https://i.picsum.photos/id/1009/5000/7502.jpg?hmac=Uj6crVILzsKbyZreBjHuMiaq_-n30qoHjqP0i7r30r8",
            userIntroduction: "李四牛逼奥",
            content: "Here you can view all the images Lorem Picsum provides.\n" +
                "\n" +
                "Get a specific image by adding /id/{image} to the start of the url.",
            imgs: [
              "https://i.picsum.photos/id/1024/1920/1280.jpg?hmac=-PIpG7j_fRwN8Qtfnsc3M8-kC3yb0XYOBfVzlPSuVII",
              "https://i.picsum.photos/id/1025/4951/3301.jpg?hmac=_aGh5AtoOChip_iaMo8ZvvytfEojcgqbCH7dzaz-H8Y",
              "https://i.picsum.photos/id/1026/4621/3070.jpg?hmac=OJ880cIneqAKIwHbYgkRZxQcuMgFZ4IZKJasZ5c5Wcw",
            ],
            type: {
              typeId: 2,
              typeName: "李四是谁"
            },
            share: 111,
            comment: 222,
            agree: 333

          },
          {
            contentId: 2,
            username: "王五",
            headImg: "https://i.picsum.photos/id/1009/5000/7502.jpg?hmac=Uj6crVILzsKbyZreBjHuMiaq_-n30qoHjqP0i7r30r8",
            userIntroduction: "王五是个好人",
            content: "我要个性网的头像大全频道,您可以发布、寻找各种男生女生头像、情侣头像、带字等个性的QQ头像。",
            imgs: [
              "https://i.picsum.photos/id/1026/4621/3070.jpg?hmac=OJ880cIneqAKIwHbYgkRZxQcuMgFZ4IZKJasZ5c5Wcw",
              "https://i.picsum.photos/id/1027/2848/4272.jpg?hmac=EAR-f6uEqI1iZJjB6-NzoZTnmaX0oI0th3z8Y78UpKM",
              "https://i.picsum.photos/id/1028/5184/3456.jpg?hmac=WhttNfn25eTgLTNnhRujSq4IVjx2mMa6wvPG1c6qMVc",
            ],
            type: {
              typeId: 3,
              typeName: "王五是谁"
            },
            share: 777,
            comment: 666,
            agree: 123

          },
        ]

      }
    },
  },
  created() {
    this.user = [
      {
        contentId: 3,
        username: "张三",
        headImg: "https://i.picsum.photos/id/1005/5760/3840.jpg?hmac=2acSJCOwz9q_dKtDZdSB-OIK1HUcwBeXco_RMMTUgfY",
        userIntroduction: "张三是个好人",
        content: "我要个性网的头像大全频道,您可以发布、寻找各种男生女生头像、情侣头像、带字等个性的QQ头像。",
        imgs: [
          "https://i.picsum.photos/id/0/5616/3744.jpg?hmac=3GAAioiQziMGEtLbfrdbcoenXoWAW-zlyEAMkfEdBzQ",
          "https://i.picsum.photos/id/1/5616/3744.jpg?hmac=kKHwwU8s46oNettHKwJ24qOlIAsWN9d2TtsXDoCWWsQ",
          "https://i.picsum.photos/id/10/2500/1667.jpg?hmac=J04WWC_ebchx3WwzbM-Z4_KC_LeLBWr5LZMaAkWkF68",
        ],
        type: {
          typeId: 1,
          typeName: "张三是谁"
        },
        share: 233,
        comment: 666,
        agree: 123

      },
      {
        contentId: 1,
        username: "李四",
        headImg: "https://i.picsum.photos/id/1009/5000/7502.jpg?hmac=Uj6crVILzsKbyZreBjHuMiaq_-n30qoHjqP0i7r30r8",
        userIntroduction: "李四牛逼奥",
        content: "Here you can view all the images Lorem Picsum provides.\n" +
            "\n" +
            "Get a specific image by adding /id/{image} to the start of the url.",
        imgs: [
          "https://i.picsum.photos/id/1024/1920/1280.jpg?hmac=-PIpG7j_fRwN8Qtfnsc3M8-kC3yb0XYOBfVzlPSuVII",
          "https://i.picsum.photos/id/1025/4951/3301.jpg?hmac=_aGh5AtoOChip_iaMo8ZvvytfEojcgqbCH7dzaz-H8Y",
          "https://i.picsum.photos/id/1026/4621/3070.jpg?hmac=OJ880cIneqAKIwHbYgkRZxQcuMgFZ4IZKJasZ5c5Wcw",
        ],
        type: {
          typeId: 2,
          typeName: "李四是谁"
        },
        share: 111,
        comment: 222,
        agree: 333

      },
      {
        contentId: 2,
        username: "王五",
        headImg: "https://i.picsum.photos/id/1009/5000/7502.jpg?hmac=Uj6crVILzsKbyZreBjHuMiaq_-n30qoHjqP0i7r30r8",
        userIntroduction: "王五是个好人",
        content: "我要个性网的头像大全频道,您可以发布、寻找各种男生女生头像、情侣头像、带字等个性的QQ头像。",
        imgs: [
          "https://i.picsum.photos/id/1026/4621/3070.jpg?hmac=OJ880cIneqAKIwHbYgkRZxQcuMgFZ4IZKJasZ5c5Wcw",
          "https://i.picsum.photos/id/1027/2848/4272.jpg?hmac=EAR-f6uEqI1iZJjB6-NzoZTnmaX0oI0th3z8Y78UpKM",
          "https://i.picsum.photos/id/1028/5184/3456.jpg?hmac=WhttNfn25eTgLTNnhRujSq4IVjx2mMa6wvPG1c6qMVc",
        ],
        type: {
          typeId: 3,
          typeName: "王五是谁"
        },
        share: 777,
        comment: 666,
        agree: 123

      },
    ]

  }
}
</script>

<style scoped>
.main-font {
  margin-left: 10%;
  margin-right: 10%;
  width: 80%;
}

.el-header, .el-footer {
  color: #333;
  text-align: left;
  line-height: 30px;
}

.el-aside {
  color: #333;
  text-align: center;
  line-height: 100px;
}

.el-main {
  color: #333;
  text-align: left;
  line-height: 70px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

.container {
  width: 240px;
  height: 240px;
  position: absolute;
  top: 50%;
  /*left: 50%;*/
  /*margin-left: -120px; !* (width + padding)/2 *!*/
  margin-top: -120px; /* (height + padding)/2 */
}

img {
  width: 100%;
  height: 100%;
  /*border-radius: 50%;*/
}

.round-icon {
  width: 34px;
  height: 34px;
  display: flex;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.flex_center {
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex-wrap: nowrap;
  flex-wrap: nowrap
}

.head_content_flex {
  display: flex;
  align-items: center
}


</style>