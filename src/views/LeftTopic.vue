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
              {{ tag }}
            </el-tag>

          </el-card>
        </el-main>
      </el-container>
    </div>


    <!--猜你喜欢-->
    <div class="main-font">
      <el-container>
        <el-header style="margin-top: 30px">
          <span style="color: blue;font-size: larger;text-align: center">猜你喜欢</span>
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
              {{ tag }}
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
              <h1 style="margin: 30px">{{item.type}}</h1>
              <el-tag style="margin: 30px" v-for="(item2,index2) in item.children" :key="index2">{{item2}}</el-tag>
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
    return {
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