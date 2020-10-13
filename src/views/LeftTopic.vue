<template>
  <div>

    <!--我关注的-->
    <div class="main-font">
      <el-container>
        <el-header style="margin-top: 30px">
          <span style="color: blue;font-size: larger;text-align: center">我关注的</span>
        </el-header>
        <el-main>
          <el-card>
            <el-tag
                :key="tag"
                v-for="tag in dynamicTags"
                closable
                :disable-transitions="false"
                @close="handleClose(tag)"
                style="margin: 30px">
              {{ tag.typeName }}
            </el-tag>

          </el-card>
        </el-main>
      </el-container>
    </div>



    <!--所有-->
    <div class="main-font">
      <el-container>
        <el-header style="margin-top: 30px">
          <span style="color: blue;font-size: larger;text-align: center">所有</span>
        </el-header>
        <el-main>
          <el-card >
            <div v-for="(item,index) in allTopic" :key="index">
              <h1 style="margin: 30px">{{index}}</h1>
              <el-tag style="margin: 30px" v-for="(item2,index2) in item" :key="index2">{{item2.typeName}}</el-tag>
            </div>
          </el-card>
        </el-main>
      </el-container>
    </div>


  </div>
</template>

<script>
export default {
  name: "LeftTopic",
  data() {
    var userInfo = JSON.parse(window.sessionStorage.getItem("userInfo"));
    return {
      user : userInfo,
      input10: '',
      activeIndex: '3',
      tags: [
        {name: '标签一', type: ''},
        {name: '标签二', type: 'success'},
        {name: '标签三', type: 'info'},
        {name: '标签四', type: 'warning'},
        {name: '标签五', type: 'danger'}
      ],
      dynamicTags: ['标签一', '标签二', '标签三'],
      inputVisible: false,
      inputValue: '',
      allTopic: [
        {type: "A", children: ["aaa", "abc", "avd", "agg"]},
        {type: "B", children: ["baa", "bbc", "bvd", "bgg"]},
        {type: "C", children: ["caa", "cbc", "cvd", "cgg"]},
        {type: "D", children: ["aaa", "abc", "avd", "agg"]},
      ]
    }
  },
  methods: {
    handleClose(tag) {
      this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
    },

  },
  created() {
    axios.get("http://localhost:8080/type/findBySortType").then(response => {
      this.allTopic = response.data
    })
    axios.get("http://localhost:8080/type/findByUserId/"+this.user.id).then(response => {
      this.dynamicTags = response.data
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


</style>