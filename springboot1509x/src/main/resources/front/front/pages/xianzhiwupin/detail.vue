
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"width":"100%","padding":"0","position":"relative","background":"url(http://codegen.caihongy.cn/20221018/6b04e4b2331b4f3d85b1103feff37414.jpg)","height":"auto"}'>
						<swiper :style='{"width":"100%","background":"#fff","height":"360rpx"}' class="swiper" :indicator-dots='false' :autoplay='false' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
				<swiper-item :style='{"width":"100%","background":"#fff","height":"360rpx"}' v-for="(swiper,index) in swiperList" :key="index">
					<image :style='{"width":"auto","margin":"0 auto","display":"block","height":"100%"}' mode="aspectFill" v-if="swiper.substring(0,4)=='http'" :src="swiper"></image>
					<image :style='{"width":"auto","margin":"0 auto","display":"block","height":"100%"}' mode="aspectFill" v-else :src="baseUrl+swiper"></image>
				</swiper-item>
			</swiper>
									            <view :style='{"width":"100%","padding":"24rpx 16rpx","flexWrap":"wrap","background":"none","display":"flex","height":"auto"}' class="detail-content">

				<view :style='{"margin":"0 0px 8rpx 0px","borderColor":"#e8e8e8","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="lable">物品名称：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text">{{detail.wupinmingcheng}}</view>
				</view>
				<view :style='{"margin":"0 0px 8rpx 0px","borderColor":"#e8e8e8","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}' class="lable">物品分类：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text">{{detail.wupinfenlei}}</view>
				</view>

				<view class="detail-list-item" :style='{"margin":"0 0px 8rpx 0px","borderColor":"#e8e8e8","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>物品编号：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.wupinbianhao}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"0 0px 8rpx 0px","borderColor":"#e8e8e8","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>新旧程度：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.xinjiuchengdu}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"0 0px 8rpx 0px","borderColor":"#e8e8e8","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>价格：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.jiage}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"0 0px 8rpx 0px","borderColor":"#e8e8e8","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>用户账号：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.yonghuzhanghao}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"0 0px 8rpx 0px","borderColor":"#e8e8e8","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333","textAlign":"right"}'>用户姓名：</view>
					<view  class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.yonghuxingming}}</view>
				</view>





				<view class="detail-list-item rich" :style='{"boxShadow":"2rpx 6rpx 6rpx #ccc","margin":"0 0 24rpx 0","borderColor":"#e8e8e8","borderRadius":"16rpx","borderWidth":"0 0 2rpx 0","background":"-webkit-linear-gradient(top,#fff,#eee)","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 8rpx","color":"#333","borderRadius":"16rpx 0 0 16rpx","textAlign":"right","background":"none","width":"208rpx","lineHeight":"80rpx","fontSize":"28rpx"}'>物品详情</view>
					<view class="rich-text" :style='{"minHeight":"240rpx","padding":"18rpx 8rpx 24rpx 16rpx","margin":"0","borderRadius":"0px 16rpx 16rpx 0px","color":"#666","background":"none","fontSize":"28rpx"}'>
						<rich-text :nodes="detail.wupinxiangqing"></rich-text>
					</view>
				</view>


				<view class="time-content" :style='{"width":"100%","margin":"0 0 24rpx 0","background":"none","height":"auto"}'>
					<view class="comoment-header" :style='{"boxShadow":"rgb(190 190 190 / 30%) 2rpx 4rpx 12rpx","borderRadius":"16rpx","background":"-webkit-linear-gradient(top,#eee,#fff)","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
						<view :style='{"padding":"0 24rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333"}'>评论</view>
						<view :style='{"padding":"0 20rpx","borderRadius":"16rpx","background":"linear-gradient(135deg, #9bc053 0%, #53c06f 56%, #20aa9a 100%)","display":"flex"}' @click="onCommentTap" class="btn-comment-content" style="display: flex;align-items: center;">
							<view :style='{"margin":"0 8rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#fff"}' class="cuIcon-add"></view>
							<view :style='{"color":"#fff","lineHeight":"80rpx","fontSize":"28rpx"}'>添加评论</view>
						</view>
					</view>
				
					<view :style='{"boxShadow":"0 2rpx 6rpx rgb(0 0 0 / 30%)","padding":"0x 0 24rpx","margin":"24rpx 0 0 0","borderRadius":"16rpx","background":"-webkit-linear-gradient(top,#eee,#fff)","width":"100%","height":"auto"}' v-for="(item,index) in commentList" v-bind:key="index" class="cu-item comment-item">
						<view :style='{"width":"100%","padding":"0 24rpx","borderRadius":"16rpx 16rpx 0 0","background":"linear-gradient(100deg, #1eaa99 0%, #78d3c6 56%, #1eaa97 100%)","display":"flex","height":"auto"}'>
							<image :style='{"width":"60rpx","margin":"4rpx 0 4rpx 0","borderRadius":"100%","display":"block","height":"60rpx"}' v-if="item.avatarurl" mode="aspectFill" :src="baseUrl+item.avatarurl"></image>
							<view :style='{"color":"#fff","lineHeight":"60rpx","fontSize":"28rpx"}' class="text-grey">{{item.nickname}}</view>
						</view>
						<view :style='{"margin":"8rpx 16rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#666"}' class="text-gray text-content text-df">
							{{item.content}}
						</view>
						<view :style='{"padding":"0 0 16rpx 0","margin":"0px 16rpx 0","lineHeight":"24rpx","fontSize":"24rpx","color":"#999"}' class="margin-top-sm text-gray text-df">{{item.addtime}}</view>
						<view v-if="item.reply" :style='{"margin":"8rpx 16rpx","lineHeight":"1.5","fontSize":"28rpx","color":"#666"}' class="text-gray text-content text-df">
							回复:{{item.reply}}
						</view>
					</view>
				</view>

				<view class="bottom-content bg-white tabbar border shop" :style='{"width":"100%","padding":"10rpx 0px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20221018/6b04e4b2331b4f3d85b1103feff37414.jpg)","display":"flex","height":"auto"}'>

					<button :style='{"border":"0","padding":"0 20rpx","margin":"0 8rpx 8rpx 0","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"linear-gradient(100deg, #f8b85d 0%, #edca98 56%, #ffaa33 100%)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="userid&&isAuth('xianzhiwupin','加入购物车')" @tap="onAcrossTap('gouwuche','','','')" class="cu-btn bg-brown round shadow-blur" >加入购物车</button>
					<button :style='{"border":"0","padding":"0 20rpx","margin":"0 8rpx 8rpx 0","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"linear-gradient(100deg, #f8b85d 0%, #edca98 56%, #ffaa33 100%)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="!userid&&isAuthFront('xianzhiwupin','加入购物车')" @tap="onAcrossTap('gouwuche','','','')" class="cu-btn bg-brown round shadow-blur" >加入购物车</button>
					<button :style='{"border":"0","padding":"0 20rpx","margin":"0 8rpx 8rpx 0","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"linear-gradient(100deg, #f8b85d 0%, #edca98 56%, #ffaa33 100%)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="userid&&isAuth('xianzhiwupin','购买')" @tap="onAcrossTap('jiaoyidingdan','','','')" class="cu-btn bg-brown round shadow-blur" >购买</button>
					<button :style='{"border":"0","padding":"0 20rpx","margin":"0 8rpx 8rpx 0","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"linear-gradient(100deg, #f8b85d 0%, #edca98 56%, #ffaa33 100%)","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="!userid&&isAuthFront('xianzhiwupin','购买')" @tap="onAcrossTap('jiaoyidingdan','','','')" class="cu-btn bg-brown round shadow-blur" >购买</button>
				</view>
			</view>

		</view>
	</view>
</mescroll-uni>
</view>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
                userid: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: {},
				count: 0,
				timer: null
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {
			this.id = options.id;
            if(options.userid) {
                this.userid = options.userid;
            }
		},
		async onShow(options) {
			// 渲染数据
			this.init();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			let cleanType = uni.getStorageSync('discussxianzhiwupinCleanType')
			if(cleanType){
				uni.removeStorageSync('discussxianzhiwupinCleanType')
				this.mescroll.num = 1
				this.upCallback(this.mescroll)
			}
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			// 支付
			onPayTap(){
				uni.setStorageSync('paytable','xianzhiwupin');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
            onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
                this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
            },
			// 跨表
			onAcrossTap(tableName,crossOptAudit,statusColumnName,tips,statusColumnValue){
				uni.setStorageSync('crossTable','xianzhiwupin');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(){
				let res = await this.$api.info('xianzhiwupin', this.id);
				this.detail = res.data;
				// 轮播图片
				this.swiperList = this.detail.tupian ? this.detail.tupian.split(",") : [];
				//修改富文本的图片样式
				this.detail.wupinxiangqing = this.detail.wupinxiangqing.replace(/img src/gi,"img style=\"width:100%;\" src");
			},

			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
                let res = await this.$api.list('discussxianzhiwupin', {
					page: mescroll.num,
					limit: 10,
					refid: this.id
				});
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.commentList = [];
				this.commentList = this.commentList.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);

            },



			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url){
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							 window.open(url);
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
			// 添加评论
			async onCommentTap() {
				this.$utils.jump(`../discussxianzhiwupin/add-or-update?refid=${this.id}`)
			},
			onSHTap() {
				this.$refs.popup.open()
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio /deep/ .uni-audio-default {
		width: inherit;
	}
</style>
