<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0px 0px 20rpx 0px","background":"url(http://codegen.caihongy.cn/20221018/6b04e4b2331b4f3d85b1103feff37414.jpg)","height":"auto"}'>
		<swiper :style='{"width":"100%","background":"#fff","height":"360rpx"}' class="swiper" :indicator-dots='true' :autoplay='true' :circular='true' indicator-active-color='#f00' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='true'>
			<swiper-item :style='{"width":"100%","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
				<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view v-if="false" :style='{"width":"100%","padding":"0 8rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#333","background":"#fff"}'>{{ swiper.title }}</view>
			</swiper-item>
		</swiper>


		<!-- menu -->
		<view v-if="true" class="menu" :style='{"padding":"0","boxShadow":"0 6rpx 6rpx #8aa8a5","margin":"0","borderRadius":"0px 0px 40rpx 40rpx","flexWrap":"wrap","background":"-webkit-linear-gradient(top,#fff,#ccf2ee)","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
            <block v-for="item in menuList" v-bind:key="item.roleName">
                <block v-if="role==item.roleName" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
                    <block v-bind:key="sort" v-for=" (child,sort) in menu.child">
                        <block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
                            <view :style='{"width":"23%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2('../'+child.tableName+'/list')">
                                <view class="iconarr" :class="child.appFrontIcon" :style='{"padding":"0","margin":"0px auto","color":"#333","borderRadius":"100%","background":"#fff","display":"block","width":"64rpx","lineHeight":"64rpx","fontSize":"64rpx","height":"64rpx"}'></view>
                                <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#333","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{child.menu.split("列表")[0]}}</view>
                            </view>
                        </block>
                    </block>
                </block>
            </block>
		</view>
		<!-- menu -->
		
		
		<!-- 关于我们 -->
		<view :style='{"padding":"0px 16rpx 0","boxShadow":"-4rpx 4rpx 8rpx rgba(180,180,180,.5),inset 0px 120rpx 112rpx 0px #85d2c9","margin":"32rpx 16rpx 32rpx 16rpx","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"calc(100% - 40rpx)","justifyContent":"center","height":"auto"}'>
		  <view :style='{"padding":"8rpx 48rpx","boxShadow":"0 6rpx 6rpx #178c7e","margin":"0 0 8rpx 0","color":"#fff","borderRadius":"8rpx 8rpx 48rpx 48rpx","textAlign":"center","background":"linear-gradient(89deg, #4ebcaf 0%, #85d2c9 56%, #0a8475 100%)","width":"auto","lineHeight":"1.5","fontSize":"36rpx"}'>{{aboutUsDetail.title}}</view>
		  <view :style='{"width":"100%","margin":"8rpx 0 20rpx","lineHeight":"1.5","fontSize":"32rpx","color":"#555","textAlign":"center"}'>{{aboutUsDetail.subtitle}}</view>
		  <view :style='{"width":"100%","padding":"0 0px","flexWrap":"wrap","display":"flex","height":"auto"}'>
		    <img :style='{"width":"calc(100% - 16rpx)","margin":"0px 8rpx 16rpx","objectFit":"cover","borderRadius":"16rpx","display":"block","height":"200rpx"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","borderRadius":"16rpx","flex":"1","display":"none","height":"160rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2">
		    <img :style='{"margin":"0px 8rpx","objectFit":"cover","borderRadius":"16rpx","flex":"1","display":"none","height":"160rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3">
		  </view>
		  <view :style='{"width":"100%","padding":"0 8rpx","margin":"0px 0 20rpx 0","lineHeight":"1.5","fontSize":"28rpx","color":"rgb(102, 102, 102)"}' v-html="aboutUsDetail.content"></view>
		  <view :style='{"width":"50%","display":"none","height":"360rpx"}' />
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		</view>

		<!-- 商品推荐 -->
		<!-- 商品推荐 -->
		
		

		<!-- 商品列表 -->
														<view class="listBox list">
			<view v-if="false && 1 == 1" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		  
			<view class="title" :style='{"padding":"0 24rpx","margin":"0 0 8rpx 0","borderRadius":"24rpx 24rpx 0px 0px","background":"linear-gradient(100deg, #1eaa99 0%, #78d3c6 56%, #1eaa97 100%)","display":"flex","width":"100%","justifyContent":"space-between"}'>
				<view :style='{"padding":"0 48rpx","margin":"16rpx 0 0 0","color":"#1eaa99","borderRadius":"16rpx 16rpx 0 0","background":"-webkit-linear-gradient(top,#eee,#fff)","fontSize":"32rpx","lineHeight":"72rpx"}'>闲置物品</view>
				<text :style='{"color":"#fff","fontSize":"32rpx","lineHeight":"88rpx"}' @tap="onPageTap('xianzhiwupin')">查看更多</text>
			</view>
			
			<view v-if="false && 1 == 2" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
		  		  
		  		  
		  		  <!-- 样式3 -->
		  <view v-if="3 == 3" class="list-box style3" :style='{"width":"100%","padding":"24rpx","margin":"0px 0px 64rpx 0px","background":"none","height":"auto"}'>
			<view @tap="onDetailTap('xianzhiwupin',product.id)" v-for="(product,index) in homexianzhiwupinlist" :key="index" class="list-item" :style='{"padding":"0px","margin":"0 0 24rpx 0","overflow":"hidden","borderRadius":"0px","background":"none","display":"block","width":"100%","position":"relative","height":"240rpx"}'>
			  			  			  			  			  			  			  			  			  <image :style='{"width":"240rpx","objectFit":"cover","borderRadius":"16rpx","float":"left","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-if="product.tupian.substring(0,4)=='http'" :src="product.tupian"></image>
			  <image :style='{"width":"240rpx","objectFit":"cover","borderRadius":"16rpx","float":"left","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.tupian?baseUrl+product.tupian.split(',')[0]:''"></image>
			  			  			  			  			  			  			  			  			  			  			  			  			  <view class="list-item-body" :style='{"padding":"0px","boxShadow":"6rpx 6rpx 6rpx rgba(180,180,180,.3),inset 0px 0px 112rpx 0px #d7f6f2","margin":"24rpx 0px 0 0","overflow":"hidden","borderRadius":"4rpx 16rpx 16rpx 4rpx","background":"#fff","width":"calc(100% - 240rpx)","float":"right","height":"192rpx"}'>
				                				                				<view :style='{"padding":"0 20rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis","height":"48rpx"}' class="list-item-title">{{product.wupinmingcheng}}</view>
								                				<view :style='{"padding":"0 20rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis","height":"48rpx"}' class="list-item-title">{{product.wupinfenlei}}</view>
								                				                				                				                				                				                																																																																																			  </view>
			</view>
		  </view>
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  
			<view v-if="false && 1 == 3" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
																																		<!-- 商品列表 -->
		
		
		<!-- 新闻资讯 -->
																										<view class="listBox news">
			<view v-if="false && 1 == 1" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"padding":"0 24rpx","margin":"0 0 8rpx 0","borderRadius":"24rpx 24rpx 0px 0px","background":"linear-gradient(100deg, #1eaa99 0%, #78d3c6 56%, #1eaa97 100%)","display":"flex","width":"100%","justifyContent":"space-between"}'>
				<view :style='{"padding":"0 48rpx","margin":"16rpx 0 0 0","color":"#1eaa99","borderRadius":"16rpx 16rpx 0 0","background":"-webkit-linear-gradient(top,#eee,#fff)","fontSize":"32rpx","lineHeight":"72rpx"}'>公告信息</view>
				<text :style='{"color":"#fff","fontSize":"32rpx","lineHeight":"88rpx"}' @tap="onPageTap('news')">查看更多</text>
			</view>
			
			<view v-if="false && 1 == 2" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
					  
						
						
		  <!-- 样式4 -->
		  		  
		  <!-- 样式5 -->
		  		  
		  <!-- 样式6 -->
		  		  
		  <!-- 样式7 -->
		  		  
		  <!-- 样式8 -->
		  		  
		  <!-- 样式9 -->
		  		  <view class="news-box6" :style='{"width":"100%","padding":"24rpx","margin":"0","background":"none","height":"auto"}'>
			<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"padding":"8rpx 24rpx 8rpx 80rpx","boxShadow":"0 2rpx 12rpx rgba(180,180,180,.3)","margin":"0 0 20rpx","borderRadius":"16rpx","background":"#fff","width":"100%","position":"relative","height":"auto"}'>
			  <view :style='{"padding":"0","margin":"-28rpx 0 0 16rpx","borderColor":"#1eaa99","color":"#1eaa99","textAlign":"center","borderRadius":"20% 40%","top":"44rpx","left":"0","borderWidth":"2rpx","width":"56rpx","lineHeight":"56rpx","fontSize":"28rpx","position":"absolute","borderStyle":"solid","height":"56rpx"}' class="num">
			    <view style="width: 100%;height: 100%;position: absolute;left: 0;top: 0;" :style="{transform: 'rotate('+(-index*60)+'deg)'}" class="dian">
			      <view :style='{"transform":"translateX(-50%)","borderRadius":"0%","top":"-8rpx","left":"50%","background":"red","width":"0px","position":"absolute","height":"0px"}'></view>
			    </view>{{ index + 1 < 10 ? '0'+(index+1) : index+1 }}
			  </view>
			  <view class="item-list-body" :style='{"width":"100%","margin":"0","height":"auto"}'>
				<view :style='{"width":"100%","padding":"4rpx 20rpx","lineHeight":"1.4","fontSize":"28rpx","color":"#333"}' class="title ">{{item.title}}</view>
				<view :style='{"padding":"4rpx 20rpx","overflow":"hidden","color":"#666","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","height":"96rpx"}' class="desc ">{{item.introduction}}</view>
			  </view>
			</view>
		  </view>
		  			
			<view v-if="false && 1 == 3" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
																						<!-- 新闻资讯 -->
				
		<!-- 系统简介 -->
		<view :style='{"padding":"0px 16rpx 0","boxShadow":"-4rpx 4rpx 8rpx rgba(180,180,180,.5),inset 0px 120rpx 112rpx 0px #85d2c9","margin":"32rpx 16rpx 32rpx 16rpx","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"calc(100% - 40rpx)","justifyContent":"center","height":"auto"}'>
		  <view :style='{"padding":"8rpx 48rpx","boxShadow":"0 6rpx 6rpx #178c7e","margin":"0 0 8rpx 0","color":"#fff","borderRadius":"8rpx 8rpx 48rpx 48rpx","textAlign":"center","background":"linear-gradient(89deg, #4ebcaf 0%, #85d2c9 56%, #0a8475 100%)","width":"auto","lineHeight":"1.5","fontSize":"36rpx"}'>{{systemIntroductionDetail.title}}</view>
		  <view :style='{"width":"100%","margin":"8rpx 0 20rpx","lineHeight":"1.5","fontSize":"32rpx","color":"#555","textAlign":"center"}'>{{systemIntroductionDetail.subtitle}}</view>
		  <view :style='{"width":"100%","padding":"0 0px","flexWrap":"wrap","display":"flex","height":"auto"}'>
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","borderRadius":"16rpx","flex":1,"display":"block","height":"160rpx"}' v-if="systemIntroductionDetail.picture1" :src="baseUrl+systemIntroductionDetail.picture1">
		    <img :style='{"margin":"0 10rpx","objectFit":"cover","borderRadius":"16rpx","flex":"2","display":"block","height":"160rpx"}' v-if="systemIntroductionDetail.picture2" :src="baseUrl+systemIntroductionDetail.picture2">
		    <img :style='{"margin":"16rpx 10rpx 8rpx","objectFit":"cover","borderRadius":"16rpx","flex":1,"display":"block","width":"calc(100% - 20rpx)","height":"160rpx"}' v-if="systemIntroductionDetail.picture3" :src="baseUrl+systemIntroductionDetail.picture3">
		  </view>
		  <view :style='{"width":"100%","padding":"0 8rpx","margin":"8rpx 0 20rpx 0","lineHeight":"1.5","fontSize":"28rpx","color":"rgb(102, 102, 102)"}' v-html="systemIntroductionDetail.content"></view>
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		  <view :style='{"width":"50%","display":"none","height":"160rpx"}' />
		</view>

	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
				  'cuIcon-same',
				  'cuIcon-deliver',
				  'cuIcon-evaluate',
				  'cuIcon-shop',
				  'cuIcon-ticket',
				  'cuIcon-cascades',
				  'cuIcon-discover',
				  'cuIcon-question',
				  'cuIcon-pic',
				  'cuIcon-filter',
				  'cuIcon-footprint',
				  'cuIcon-pulldown',
				  'cuIcon-pullup',
				  'cuIcon-moreandroid',
				  'cuIcon-refund',
				  'cuIcon-qrcode',
				  'cuIcon-remind',
				  'cuIcon-profile',
				  'cuIcon-home',
				  'cuIcon-message',
				  'cuIcon-link',
				  'cuIcon-lock',
				  'cuIcon-unlock',
				  'cuIcon-vip',
				  'cuIcon-weibo',
				  'cuIcon-activity',
				  'cuIcon-friendadd',
				  'cuIcon-friendfamous',
				  'cuIcon-friend',
				  'cuIcon-goods',
				  'cuIcon-selection'
				],
                role : '',
                aboutUsDetail: {},
                systemIntroductionDetail: {},
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',

				//轮播
				swiperList: [],
				homexianzhiwupinlist: [],
				news: [],
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
        async onLoad(){
            this.role = uni.getStorageSync("role");
            let table = uni.getStorageSync("nowTable");
            let res = await this.$api.session(table);
            this.user = res.data;
            this.tableName = table;
            let menus = menu.list();
            this.menuList = menus;
            this.menuList.forEach((item,key) => {
                if(this.role==item.roleName) {
                    item.frontMenu.forEach((item2,key2) => {
                        if(item2.child[0].buttons.indexOf("查看")>-1) {
                            this.swiperMenuList.push(item2);
                        }
                    })
                }
            })
        },
		async onShow() {
			// 轮播图
			let swiperList = []
			let res = await this.$api.page('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
            this.getAboutUs();
            this.getSystemIntroduction();
			// 公告信息
			res = await this.$api.list('news', {
				page: 1,
				limit: 6
			});
			this.news = res.data.list


			res = await this.$api.list('xianzhiwupin', {
				page: 1,

				limit: 6
			});
			this.homexianzhiwupinlist = res.data.list
		},

		methods: {

			//轮播图跳转
			onSwiperTap(e) {

			},
            async getAboutUs() {
                let res = await this.$api.info('aboutus', 1)
                this.aboutUsDetail = res.data;
            },
            async getSystemIntroduction() {
                let res = await this.$api.info('systemintro', 1)
                this.systemIntroductionDetail = res.data;
            },
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(url) {
                uni.setStorageSync("useridTag",0);
                uni.navigateTo({
                    url: url,
                    fail: function() {
                        uni.switchTab({
                            url: url
                        });
                    }
                });
            }
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
