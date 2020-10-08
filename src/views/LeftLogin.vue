<template>
  <div>
    <el-card class="main-font">
      <el-alert v-if="flag"
          title="用户名或密码错误"
          type="error"
          center
          show-icon>
      </el-alert>
      <el-tabs v-model="activeName">

        <el-tab-pane label="登录" name="first">
          <el-form ref="form" label-width="80px">
            <el-form-item label="用户名">
              <el-input style="width: 50%" placeholder="请输入用户名" v-model="user.username"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input type="password" style="width: 50%" placeholder="请输入密码" v-model="user.password"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="login">登录</el-button>
              <span style="margin-left: 30px">没有账户?</span><a href="#" @click="createUser">创建一个</a>
            </el-form-item>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="注册" name="second">
          <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px"
                   class="demo-ruleForm">
            <el-form-item label="用户名" prop="name">
              <el-input v-model="ruleForm2.name" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pass">
              <el-input type="password" v-model="ruleForm2.pass" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input type="password" v-model="ruleForm2.checkPass" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="年龄">
              <div class="block">
                <el-slider v-model="user.age"></el-slider>
              </div>
            </el-form-item>
            <el-form-item label="性别">
              <el-radio-group v-model="a" @change="test">
                <el-radio :label="0">男</el-radio>
                <el-radio :label="1">女</el-radio>
                <el-radio :label="2">外星人</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="头像url">
              <el-input auto-complete="off" v-model="user.headImg"></el-input>
            </el-form-item>
            <el-form-item label="出生日期">
              <el-date-picker
                  v-model="user.birthday"
                  type="date"
                  placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="register">提交</el-button>
              <el-button @click="resetForm('ruleForm2')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>
      </el-tabs>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "LeftLogin",
  data() {
    var checkUserName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'));
      } else {
        axios.get("http://localhost:8080/user/findUserName/" + this.ruleForm2.name).then(response => {
              if (response.data === "error") {
                callback(new Error('该用户名已存在'));
              } else {
                console.log(this.user.gender)
                callback()
                this.user.username = this.ruleForm2.name
              }
            }
        )
      }
    }

    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm2.checkPass !== '') {
          this.$refs.ruleForm2.validateField('checkPass');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm2.pass) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        this.user.password = value
        callback();
      }
    };

    return {
      user: {
        id: '',
        username: '',
        password: '',
        age: '',
        gender: '1',
        birthday: '',
        headImg: '',
      },
      flag: false,
      a: 1,
      ruleForm2: {
        pass: '',
        checkPass: '',
        name: '',
      },
      rules2: {
        pass: [
          {validator: validatePass, trigger: 'blur'}
        ],
        checkPass: [
          {validator: validatePass2, trigger: 'blur'}
        ],
        name: [
          {validator: checkUserName, trigger: 'blur'}
        ]
      },
      activeName: 'first',
    };
  }
  ,
  methods: {

    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
    ,
    login() {
      axios.post("http://localhost:8080/user/login/", this.user).then(response => {
        if (response.data === "") {
          this.flag = true;
        } else {
          this.flag = false;
          this.user = response.data
          window.sessionStorage.setItem("userInfo",JSON.stringify(this.user))
          this.$router.push("/")
        }
      })
    }
    ,
    register() {
      this.user.gender = this.a
      axios.post("http://localhost:8080/user/register/", this.user).then(response => {
        this.createUser();
      })
    },
    createUser() {
      if (this.activeName === 'first') {
        this.activeName = 'second'
      } else {
        this.activeName = 'first'
      }
    },
    test() {
      console.log(this.user.gender = this.a)
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
</style>