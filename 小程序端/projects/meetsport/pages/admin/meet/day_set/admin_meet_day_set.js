const AdminBiz = require('../../../../../../comm/biz/admin_biz.js');
const pageHelper = require('../../../../../../helper/page_helper.js');
const cloudHelper = require('../../../../../../helper/cloud_helper.js');
const dataHelper = require('../../../../../../helper/data_helper.js');
const validate = require('../../../../../../helper/validate.js');
const MeetBiz = require('../../../../biz/meet_biz.js');
const AdminMeetBiz = require('../../../../biz/admin_meet_biz.js');
const projectSetting = require('../../../../public/project_setting.js');


Page({

	/**
	 * 页面的初始数据
	 */
	data: {
		days: []
	},

	/**
	 * 生命周期函数--监听页面加载
	 */
	async onLoad(options) {
		if (!AdminBiz.isAdmin(this)) return;
		if (!pageHelper.getOptions(this, options)) return;
		let idx = options.idx;

		let parent = pageHelper.getPrevPage(2);
		if (!parent) return;

		let days = parent.data.dataList.list[idx].meetDays;

		this.setData({ idx, days, isLoad: true });
	},

	/**
	 * 生命周期函数--监听页面初次渲染完成
	 */
	onReady() {

	},

	/**
	 * 生命周期函数--监听页面显示
	 */
	onShow() {

	},

	/**
	 * 生命周期函数--监听页面隐藏
	 */
	onHide() {

	},

	/**
	 * 生命周期函数--监听页面卸载
	 */
	onUnload() {

	},

	/**
	 * 页面相关事件处理函数--监听用户下拉动作
	 */
	onPullDownRefresh() {

	},

	/**
	 * 页面上拉触底事件的处理函数
	 */
	onReachBottom() {

	},

	url: function (e) {
		pageHelper.url(e, this);
	},

	bindDataCalendarClickCmpt: function (e) {
		let days = e.detail.days;
		this.setData({ days });
	},

	bindSaveTap: async function (e) {
		let params = {
			meetId: this.data.id,
			days: JSON.stringify(this.data.days)
		}
		let callback = async () => {
			try {
				await cloudHelper.callCloudSumbit('/admin/meet/set/days', params).then(res => {
					let cb = () => {
						let parent = pageHelper.getPrevPage(2);
						if (parent) {
							parent.setData({
								['dataList.list[' + this.data.idx + '].meetDays']: this.data.days
							})
						}
						wx.navigateBack();
					}
					pageHelper.showSuccToast('设置成功', 1500, cb);
				});
			}
			catch (err) {
				console.error(err);
			}
		}
		pageHelper.showConfirm('确认保存？', callback);
	}
})