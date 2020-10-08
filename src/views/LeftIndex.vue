<template>
  <div>


    <!--文章内容-->

    <el-card class="box-card main-font" style="margin-top: 20px;width: 80%" v-for="(item ,index) in blogs" :key="index">
      <!--头像 用户名-->
      <div class="flex_center">
        <!--            <el-row type="flex" justify="left">-->
        <!--              <el-col :span="16" align="center" >-->
        <div class="head_content_flex">

          <div class="round-icon">
            <img :src="item.user.headImg">
          </div>

          <div>
            <el-alert
                v-bind:title="item.user.username"
                type="success"
                :closable="false"
                style="background: white"
                v-bind:description="item.user.introduction"
            >
            </el-alert>
          </div>
        </div>


        <div class="grid-content bg-purple" v-if="showButton(item.user.id)">
          <el-button round @click="watch(item.user.id)"><i class="el-icon-circle-plus-outline"></i>关注</el-button>
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
            <el-carousel-item v-for="(item2,index2) in item.urls" :key="index2">
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
            <el-button icon="el-icon-share">{{ item.agreeNumber }}</el-button>
          </el-col>
          <el-col :span="3">
            <el-button icon="el-icon-edit" @click="comment(item.contentId)">{{ item.comments.length }}</el-button>
          </el-col>
          <el-col :span="5">
            <el-button icon="el-icon-arrow-up" @click="addNumber(index)">{{ item.agreeNumber }}</el-button>
            <el-button icon="el-icon-arrow-down" @click="subNumber(index)"></el-button>
          </el-col>
        </el-row>
      </div>
    </el-card>


    <!--分页-->
    <div style="margin-top: 30px">
      <el-row type="flex" justify="center">
        <el-col :span="8">
          <el-pagination
              @current-change="getPage"
              :current-page.sync="currentPage1"
              :page-size="5"
              layout="total, prev, pager, next"
              :total="blogCount">
          </el-pagination>
        </el-col>
      </el-row>
    </div>

    <!--发布新话题-->
    <div class="box-fixed">
      <el-tooltip class="item" effect="dark" content="发布新内容~" placement="left">
        <el-button round type="primary" @click="dialogVisible = true"><i class="el-icon-circle-plus-outline"></i>
        </el-button>
      </el-tooltip>
    </div>

    <el-dialog
        prefix-icon=""
        title="发布新内容"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose">
      <!--提交的内容-->
      <div>

        <el-autocomplete
            v-model="state1"
            :fetch-suggestions="querySearch"
            placeholder="请选择话题"
            @select="handleSelect">
          <template slot-scope="props">
            <div>{{ props.item.typeName }}</div>
          </template>
        </el-autocomplete>

        <el-input
            style="margin-top: 30px"
            placeholder="请输入内容"
            prefix-icon="el-icon-edit"
            v-model="blog.content"
            clearable
            maxlength="100"
        >
        </el-input>
        <el-input
            type="textarea"
            :rows="2"
            style="margin-top: 30px"
            placeholder="请输入图片url，多个url用;分割"
            v-model="blog.imgUrl"
            clearable
        >
        </el-input>
      </div>


      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="content">确 定</el-button>
      </span>
    </el-dialog>

  </div>


</template>

<script>
export default {
  name: "LeftIndex",
  data() {
    var userInfo = JSON.parse(window.sessionStorage.getItem("userInfo"));
    var aData = new Date();
    var nowDate = aData.getFullYear() + "-" + (aData.getMonth() + 1) + "-" + aData.getDate();
    return {
      currentPage1: 1,
      blogCount: 1,
      blog: {
        content: "",
        createDate: nowDate,
        agreeNumber: 0,
        imgUrl: "",
        type: {
          id: ""
        },
        user: {
          id: userInfo.id,
        }
      },
      state1: '',
      dialogVisible: false,
      types: [],
      blogs: [
        {
          contentId: 3,
          username: "张三",
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
      ],
      watched: [],
    }
  },
  methods: {
    watch(watchId) {
      let fansId = this.blog.user.id
      axios.post("http://localhost:8080/user/watch/" + fansId + "/" + watchId).then(response => {
        if (response.data != null){
          this.watched = response.data
          const h = this.$createElement;
          this.$notify({
            title: 'OMG!!!!!',
            message: h('i', { style: 'color: teal'}, '关注成功了嗷')
          });
        } else {
          const h = this.$createElement;
          this.$notify({
            title: 'emmmm.....',
            message: h('i', { style: 'color: teal'}, '好像出现了点问题')
          });
        }
      })
    },
    showButton(a) {
      for (let i = 0; i < this.watched.length; i++) {
        if ((a == this.watched[i].id) || (a == this.blog.user.id)) {
          return false
        }
      }
      return true
    },
    addNumber(pageId) {
      this.blogs[pageId].agreeNumber += 1
      axios.get("http://localhost:8080/blog/addAgreeNumber/" + this.blogs[pageId].id).then(response => {
        this.blogs[pageId] = response.data
      })
    },
    subNumber(pageId) {
      this.blogs[pageId].agreeNumber -= 1
      axios.get("http://localhost:8080/blog/subAgreeNumber/" + this.blogs[pageId].id).then(response => {
        this.blogs[pageId] = response.data
        console.log(this.blogs)
      })
    },
    getPage(val) {
      axios.get("http://localhost:8080/blog/findAll/" + (val - 1)).then(response => {
        this.blogs = response.data
      })
    },
    comment(id) {
      this.$router.push({path: "/content", query: {id: id}})
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {
          });
    },
    content() {
      axios.post("http://localhost:8080/blog/addBlog/", this.blog).then(response => {
        if (response.data != null) {
          this.blog.imgUrl = ""
          this.blog.content = ""
          this.blog.type.id = ""
          const h = this.$createElement;

          this.$notify({
            title: '嘿嘿嘿',
            message: h('i', {style: 'color: teal'}, '发表成功！！')
          });
          axios.get("http://localhost:8080/blog/findCount").then(response => {
            this.blogCount = response.data
          })
        }
      })
      this.dialogVisible = false
    },
    querySearch(queryString, cb) {
      var restaurants = this.types;
      var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter(queryString) {
      return (restaurant) => {
        return (restaurant.typeName.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
      };
    },

    handleSelect(item) {
      this.state1 = item.typeName
      this.blog.type.id = item.id
      console.log(this.blog)
    },


  },
  created() {
    axios.get("http://localhost:8080/type/findAll").then(response => {
      this.types = response.data
    })
    axios.get("http://localhost:8080/blog/findAll/0").then(response => {
      this.blogs = response.data
    })
    axios.get("http://localhost:8080/blog/findCount").then(response => {
      this.blogCount = response.data
    })
    axios.get("http://localhost:8080/user/getWatch/" + this.blog.user.id).then(response => {
      this.watched = response.data
    })
  }

}
</script>

<style scoped>
.main-font {
  margin-left: 10%;
  margin-right: 10%;
  width: 80%;
}

.box-card {
  width: 480px;
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

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
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

.box-fixed {
  position: fixed;
  bottom: 10px;
  right: 30px;
  width: 30px;
  padding: 20px;
}

.item {
  margin: 4px;
}


</style>