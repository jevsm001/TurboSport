module.exports = { // meetsport
	PROJECT_COLOR: '#3366FF',
	NAV_COLOR: '#ffffff',
	NAV_BG: '#3366FF',

	// setup
	SETUP_CONTENT_ITEMS: [
		{ title: '关于我们', key: 'SETUP_CONTENT_ABOUT' },
		{ title: '用户注册使用协议', key: 'SETUP_YS' }
	],

	// 用户 
	USER_FIELDS: [
		{ mark: 'sex', title: '性别', type: 'select', selectOptions: ['男', '女'], must: true },
		{ mark: 'birth', type: 'date', title: '出生年月', must: true },
	],


	NEWS_NAME: '公告',
	NEWS_CATE: [
		{ id: 1, title: '公告通知' },
		{ id: 2, title: '运动常识' },
	],
	NEWS_FIELDS: [
		{ mark: 'desc', type: 'textarea', title: '简介', must: true, min: 2, max: 200 },
		{ mark: 'content', title: '详细内容', type: 'content', must: true },
		{ mark: 'cover', type: 'image', title: '封面图', must: true, min: 1, max: 1 },
	],


	MEET_NAME: '预约',
	MEET_CATE: [
		{ id: 1, title: '篮球场' },
		{ id: 2, title: '足球场' },
		{ id: 3, title: '排球场' },
		{ id: 4, title: '羽毛球' },
		{ id: 5, title: '乒乓球' },
		{ id: 6, title: '健身房' },
		{ id: 7, title: '游泳' },
		{ id: 8, title: '轮滑' },
		{ id: 9, title: '网球' },
		{ id: 10, title: '田径场' },

	],
	MEET_FIELDS: [
		{ mark: 'cover', title: '封面图', type: 'image', min: 1, max: 1, must: true },
		{ mark: 'time', title: '预约时段设置', type: 'rows', ext: { titleName: '时段', maxCnt: 15, minCnt: 1 }, must: false },
		{ mark: 'tag', title: '特色', type: 'checkbox', selectOptions: ['饮水机', '洗手间', '休息室', '充电宝', '近地铁', 'WIFI', '裁判服务', '培训服务', '淋浴间'], ext: { show: 'row' }, checkBoxLimit: 0, must: false },
		{ mark: 'desc', title: '预约须知', type: 'content', must: true },
	],
	MEET_JOIN_FIELDS: [
		{ mark: 'name', type: 'text', title: '姓名', must: true, max: 30 },
		{ mark: 'phone', type: 'mobile', title: '手机', must: true, edit: false }
	],


}