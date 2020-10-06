<template>
  <div>
    <el-card class="box-card main-font" style="margin-top: 20px;width: 80%">
      <div class="flex_center">
        <!--            <el-row type="flex" justify="left">-->
        <!--              <el-col :span="16" align="center" >-->
        <div class="head_content_flex">

          <div class="round-icon">
            <img :src="content.headImg">
          </div>

          <div>
            <el-alert
                v-bind:title="content.username"
                type="success"
                :closable="false"
                style="background: white"
                v-bind:description="content.userIntroduction"
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
            <span>{{ content.content }}</span>
          </div>
          <el-carousel :interval="5000" arrow="always" style="width: 80%" class="main-font">
            <el-carousel-item v-for="(item2,index2) in content.imgs" :key="index2">
              <img :src="item2">
            </el-carousel-item>
          </el-carousel>
        </div>
      </div>
      <!--标签-->
      <div style="margin-top: 10px">
        <el-tag type="success">{{ content.type.typeName }}</el-tag>
      </div>
      <!--点赞 评论 XX-->
      <div>
        <el-row type="flex" justify="center">
          <el-col :span="3">
            <el-button icon="el-icon-share">{{ content.share }}</el-button>
          </el-col>
          <el-col :span="3">
            <el-button icon="el-icon-edit">{{ content.comment }}</el-button>
          </el-col>
          <el-col :span="5">
            <el-button icon="el-icon-arrow-up">{{ content.agree }}</el-button>
            <el-button icon="el-icon-arrow-down"></el-button>
          </el-col>
        </el-row>
      </div>
      <!--评论-->
      <div style="margin-top: 30px">
        <div>
          <el-row type="flex" class="row-bg" justify="space-between">
            <el-col :span="6">
              <span style="color: blueviolet;font-size: 30px;">评论</span>
            </el-col>
            <el-col :span="6" align="right">
              <el-dropdown>
                <span class="el-dropdown-link">
                  排序方式<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item>热度</el-dropdown-item>
                  <el-dropdown-item>时间</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </el-col>
          </el-row>
        </div>
        <!--网名 评论内容 赞 踩-->
        <div class="flex_center" v-for="(item,index) in comments" :key="index">
          <div class="head_content_flex">
            <a href="#">{{ item.username }}</a>
            <div>
              <el-alert
                  v-bind:title="item.content"
                  type="success"
                  :closable="false"
                  style="background: white"
              >
              </el-alert>
            </div>
            <div>
              <el-tag>{{ item.date }}</el-tag>
            </div>
          </div>
          <div class="grid-content bg-purple">
            <a href="#" style="padding-right: 30px"><i class="el-icon-caret-top"></i>{{ item.agree }}</a>
            <a href="#"><i class="el-icon-caret-bottom"></i></a>
          </div>
        </div>
      </div>

    </el-card>

    <!--发布新评论-->
    <div class="box-fixed">
      <el-tooltip class="item" effect="dark" content="发布新评论~" placement="left">
        <el-button round type="primary" @click="dialogVisible = true"><i class="el-icon-circle-plus-outline"></i>
        </el-button>
      </el-tooltip>
    </div>

    <el-dialog
        title="添加评论"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose">
      <el-input
          clearable
          maxlength="50"
          placeholder="请输入评论"
          v-model="input2">
      </el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>


  </div>
</template>

<script>
export default {
  name: "LeftContent",
  data() {
    return {
      input10: '',
      activeIndex: '3',
      activeName: 'second',
      textarea2: '',
      content: {
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
      comments: [
        {
          username: "张三", content: " 关于element-ui+vue-cli,导航跳转问题Vue.js ", date: "\n" +
              "20点04分", agree: 123
        },
        {
          username: "李四", content: "现在我想要点击导航下拉中的文章,保留导航,导航", date: "\n" +
              "20点04分", agree: 111
        },
        {
          username: "王五", content: " sdn已为您找到关于vue三种跳转方式相关", date: "\n" +
              "20点04分", agree: 23
        },
      ],
      dialogVisible: false,
      input2: ""
    }
  },
  methods: {
    handleClose(done) {
      this.$confirm('关闭后将不会保存')
          .then(_ => {
            done();
          })
          .catch(_ => {
          });
    }
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
  background-color: white;
  color: #333;
}

.el-aside {
  color: #333;
  text-align: center;
  line-height: 100px;
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  line-height: 160px;
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

.box-fixed {
  position: fixed;
  bottom: 10px;
  right: 30px;
  width: 30px;
  padding: 20px;
}


</style>