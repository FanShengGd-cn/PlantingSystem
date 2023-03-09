<template>
  <div>
    <h2>上传图片进行识别</h2>
    <div style="width: 800px;margin-left: 5vw;float: left">
      <el-upload
          class="avatar-uploader"
          action="http://localhost:9090/upload/uploadDetectImg"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
        <img style="color: #409EFF" v-if="imageUrl" :src="imageUrl" class="avatar">
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>
      <div style="width:200px;text-align: center; margin: auto;position: relative">{{
          fileName ? fileName : '点击上方上传图片'
        }}
      </div>
    </div>
    <div style="float: left;line-height: 800px;margin-left: 2vw">
      <el-button style="height: 50px;font-size: 18px" type="primary">{{
          uploadSuccess ? '识别完成' : '上传图片自动识别'
        }}
      </el-button>
    </div>
    <div style="float: left;margin-left: 2vw">
      <el-image v-if="src" :src="'data:image/png;base64,'+src" class="avatar"></el-image>
    </div>

  </div>
<!--    &lt;!&ndash; 上传相关 &ndash;&gt;-->
<!--    <div class="masking" v-show="visible">-->
<!--        <div class="addPhotoContainer"></div>-->
<!--        <div class="addController">-->
<!--            <h3 class="addTitle">-->
<!--                上传照片-普通上传(H5)<span class="close" @click="closeWrapper">╳</span>-->
<!--            </h3>-->
<!--            <div class="photoTitles">-->
<!--                <span class="uploadTo">上传到</span>-->
<!--                <div class="photoSelect">-->
<!--                    <img class="showPhoto" src="public/img/1.jpg" />-->
<!--                    相册名称-->
<!--                </div>-->
<!--            </div>-->

<!--            &lt;!&ndash; 上传按钮 &ndash;&gt;-->
<!--            <div class="showContainer" v-show="upBtn">-->
<!--                <div class="uploadContainer">-->
<!--          <span class="fileinput-button">-->
<!--            <span>上传图片</span>-->
<!--              &lt;!&ndash; 绑定input事件监听为uploadPhoto函数 &ndash;&gt;-->
<!--            <input-->
<!--                    class="imgFile"-->
<!--                    type="file"-->
<!--                    name=""-->
<!--                    multiple="multiple"-->
<!--                    @input="uploadPhoto"-->
<!--            />-->
<!--          </span>-->
<!--                    <span class="hint">-->
<!--            按住Ctrl可多选-->
<!--          </span>-->
<!--                </div>-->
<!--            </div>-->

<!--            &lt;!&ndash; 显示待上传图片  &ndash;&gt;-->
<!--            <div class="loadContainer" v-show="upWrapper">-->
  <!--                <div class="wantUpload">-->
  <!--                    <template v-for="(item, index) in toBeUpLoaded">-->
  <!--                        &lt;!&ndash; 显示待上传图片 &ndash;&gt;-->
  <!--&lt;!&ndash;                        <UpLoadPhotoItem :key="index" :item="item" />&ndash;&gt;-->
  <!--                    </template>-->
  <!--                </div>-->
  <!--                <div class="addStyle">-->
  <!--          <span class="fileinput-add">-->
  <!--            <span></span>-->
  <!--            <input class="imgFile-add" type="file" multiple="multiple" />-->
  <!--          </span>-->
  <!--                </div>-->
  <!--                &lt;!&ndash; 开始上传按钮 &ndash;&gt;-->
  <!--                <div class="bottomStyle" @click="beginUpload">-->
  <!--                    <span class="uploadBtn">开始上传</span>-->
  <!--                </div>-->
  <!--            </div>-->
  <!--        </div>-->
  <!--    </div>-->
</template>
<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 800px;
  height: 800px;
  line-height: 800px;
  text-align: center;
}
.avatar {
  width: 800px;
  height: 800px;

  display: block;
}
</style>
<script>
import request from "@/utils/request";
    // 待上传图片的组件
    // import UpLoadPhotoItem from "./upLoadPhotoItem.vue";
    //不是export default导出的模块都要用{}来包括导出。
    //没有文件
    // import { apiUpLoad } from "../api";
    export default {
        components: {
            // UpLoadPhotoItem,
        },
        // visible是父级传入的数据
        props: ["visible"],
        data() {
            return {
              // 用于存放待上传的图片信息
              toBeUpLoaded: [],
              fileName: '',
              imageUrl: '',
              uploadSuccess: false,
              src: ''
            };
        },
        computed: {
            // 如果有需要上传的图片，隐藏上传按钮，把待上传框显示，如果没有要上传的图片，就把上传按钮显示出来，隐藏待上传框
            upBtn() {
                return this.toBeUpLoaded.length === 0;
            },
            upWrapper() {
                return this.toBeUpLoaded.length > 0;
            },
        },
        methods: {
            // 点击上传按钮，触发该函数
            // async beginUpload() {
            //     // 遍历待上传的图片
            //     // 当图片上传到后端，后端需要把数据存到数据库(花时间)
            //     for (const photos of this.toBeUpLoaded) {
            //         await apiUpLoad(photos);
          //     }
          //     // 写好代码，表达好意图
          //     this.upLoadCompleted();
          // },
          // upLoadCompleted() {
          //     // 图片上传完成后，清空待上传数组
          //     this.toBeUpLoaded = [];
          //     // 获取服务端的图片信息，更新vuex里的photos，从而更新DOM
          //     this.$store.dispatch('getPhotos');
          // },
          // closeWrapper() {
          //     // 响应父级的visible，把false值传递给父级的visible
          //     this.$emit("update:visible", false);
          // },
          // uploadPhoto(e) {
          //     // 获取上传图片的信息
          //     // Array.from 把类数组整理成数组，...解构出来每一个数组对象
          //     // 把上传图片的信息全部放到待上传数组里
          //     this.toBeUpLoaded.push(...Array.from(e.target.files));
          // },
          receiveImg() {
            request.get("/Engine/page", {
              params: {
                pageNum: this.pageNum,
                pageSize: this.pageSize,
                username: this.username,
                email: this.email,
                address: this.address
              }

            }).then(res => {
              console.log(res)
              this.tableData = res.records
              this.total = res.total
            })
          },


          handleAvatarSuccess(res, file) {
            this.imageUrl = URL.createObjectURL(file.raw)
            console.log(file)
            this.uploadSuccess = true
            this.fileName = file.name
            this.src = file.response
          },
          beforeAvatarUpload(file) {
            const isJPG = file.type === 'image/jpeg' || 'image/png';
            const isLt2M = file.size / 1024 / 1024 < 1;

            if (!isJPG) {
              this.$message.error('上传头像图片只能是 JPG 或 PNG 格式!');
            }
            if (!isLt2M) {
              this.$message.error('上传头像图片大小不能超过 1MB!');
            }
            return isJPG && isLt2M;
          }
        },
    };
</script>
