<template>
    <!-- 上传相关 -->
    <div class="masking" v-show="visible">
        <div class="addPhotoContainer"></div>
        <div class="addController">
            <h3 class="addTitle">
                上传照片-普通上传(H5)<span class="close" @click="closeWrapper">╳</span>
            </h3>
            <div class="photoTitles">
                <span class="uploadTo">上传到</span>
                <div class="photoSelect">
                    <img class="showPhoto" src="public/img/1.jpg" />
                    相册名称
                </div>
            </div>

            <!-- 上传按钮 -->
            <div class="showContainer" v-show="upBtn">
                <div class="uploadContainer">
          <span class="fileinput-button">
            <span>上传图片</span>
              <!-- 绑定input事件监听为uploadPhoto函数 -->
            <input
                    class="imgFile"
                    type="file"
                    name=""
                    multiple="multiple"
                    @input="uploadPhoto"
            />
          </span>
                    <span class="hint">
            按住Ctrl可多选
          </span>
                </div>
            </div>

            <!-- 显示待上传图片  -->
            <div class="loadContainer" v-show="upWrapper">
                <div class="wantUpload">
                    <template v-for="(item, index) in toBeUpLoaded">
                        <!-- 显示待上传图片 -->
<!--                        <UpLoadPhotoItem :key="index" :item="item" />-->
                    </template>
                </div>
                <div class="addStyle">
          <span class="fileinput-add">
            <span></span>
            <input class="imgFile-add" type="file" multiple="multiple" />
          </span>
                </div>
                <!-- 开始上传按钮 -->
                <div class="bottomStyle" @click="beginUpload">
                    <span class="uploadBtn">开始上传</span>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
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
            async beginUpload() {
                // 遍历待上传的图片
                // 当图片上传到后端，后端需要把数据存到数据库(花时间)
                for (const photos of this.toBeUpLoaded) {
                    await apiUpLoad(photos);
                }
                // 写好代码，表达好意图
                this.upLoadCompleted();
            },
            upLoadCompleted() {
                // 图片上传完成后，清空待上传数组
                this.toBeUpLoaded = [];
                // 获取服务端的图片信息，更新vuex里的photos，从而更新DOM
                this.$store.dispatch('getPhotos');
            },
            closeWrapper() {
                // 响应父级的visible，把false值传递给父级的visible
                this.$emit("update:visible", false);
            },
            uploadPhoto(e) {
                // 获取上传图片的信息
                // Array.from 把类数组整理成数组，...解构出来每一个数组对象
                // 把上传图片的信息全部放到待上传数组里
                this.toBeUpLoaded.push(...Array.from(e.target.files));
            },
        },
    };
</script>
