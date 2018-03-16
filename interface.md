## 前端需要的接口
- [x] GET 获得教师基本信息
- [x] GET 获得教师参与项目
- [x] GET 获得教师所发文章
- [x] GET 获得教师招生信息

- [x] GET 获得教师留言板信息
require teacherID 要查询留言板的老师的ID
response {
subject: [
	{
		subjectID: String, 帖子的ID
		timestamp: String 主题的时间戳
		topic: String, 帖子主题
		content: String, 帖子内容
		reply: [
			{
				timestamp: String, 时间戳
				content: String 内容
			}
		] 所有回复装在一个数组中
	}
]
}
e.g.
{
	subject: [
		{
			subjectID: ""
			topic: "lalalala",
			content: "im lalalalallalalalala",
			reply: [
			{
				timestamp: "1514808000000"
				content: "aaaaaaaa"
			},
			{
				timestamp: "1519905600000"
				content: "bbb"
			},
			{
				timestamp: "1519862400000"
				content: "ccc"
			},
		]
	},
	{
		subjectID: ""
		topic: "fwefewf",
		content: "ffffffffffff",
		reply: [
		{
			timestamp: "1514808000000"
			content: "bvbv"
		},
		{
			timestamp: "1519905600000"
			content: "bvb"
		},
		{
			timestamp: "1519862400000"
			content: "cvc"
		},
	]
	},
	{
		subjectID: ""
		topic: "lalalala",
		content: "im lalalalallalalalala",
		reply: [
		{
			timestamp: "1514808000000"
			content: "aaaaaaaa"
		},
		{
			timestamp: "1519905600000"
			content: "bbb"
		},
		{
			timestamp: "1519862400000"
			content: "ccc"
		},
	]
	},
]
}

- [x] GET 获得某个帖子的所有回复
require: {
	teacherID: String,
	subjectID: String
}
response: {
	reply: [
		{
			timestamp: String, 时间戳
			content: String 内容
		}
	]
}

- [x] POST 新建留言板主题
require: {
	teacherID: String,
	topic: String,
	content: String
}
response null

- [x] POST 新建留言板回复
require {
	teacherID: String,
	subjectID: String,
	content: String
}
response null

- [x] GET 获得所有大类学科

- [x] GET 获得所有学院名字列表
require null
response {
	items: [
		{
			name: String, 学院名
			institutionID: String 学院ID
		}
	]
}
e.g.:
{
	items:[{name: "xx学院", instituteID: "x"}, {name: "yy学院", instituteID: "y"}, {name: "zz学院", instituteID: "z"}]
}
- [x] GET 发送老师姓名/ID 获得该老师的访问量

- [x] GET 发送某个学院ID，返回该学院所有老师基本信息
require {instituteID: String} 学院ID
response {
	items: [
		{
			teacherID: String,
			name: String,
			title: String,
			direction: String,
			brief: String
		}
	]
}
e.g.:
{
	items: [
		{
			teacherID: "id1",
			name: "[教师名]",
			title: "[职称]",
			direction: "[研究方向]",
			brief: "[简介]"
		},
		{
			teacherID: "id2",
			name: "[教师名]",
			title: "[职称]",
			direction: "[研究方向]",
			brief: "[简介]"
		},
		{
			teacherID: "id3",
			name: "[教师名]",
			title: "[职称]",
			direction: "[研究方向]",
			brief: "[简介]"
		},
		{
			teacherID: "id4",
			name: "[教师名]",
			title: "[职称]",
			direction: "[研究方向]",
			brief: "[简介]"
		},
		{
			teacherID: "id5",
			name: "[教师名]",
			title: "[职称]",
			direction: "[研究方向]",
			brief: "[简介]"
		},
		{
			teacherID: "id6",
			name: "[教师名]",
			title: "[职称]",
			direction: "[研究方向]",
			brief: "[简介]"
		},
	]
}
- [x] GET 获得访问次数最多的老师们的基本信息

- [x] GET 获得最近更新的老师们的基本信息

- [x] UPDATE 发送老师姓名/ID 更新访问量

- [x] GET 发送查询字符串和查询类别 获得查询结果
require {searchType: Number, value: String}
response {
	items: [
		{
			teacherID: String,
			name: String,
			title: String,
			direction: String,
			brief: String
		}
	]
}

- [ ] POST 登录请求 验证并进入后台
- [x] PUT 修改教师基本信息
- [x] PUT 修改教师参与项目
- [ ] PUT 修改教师所发文章
- [x] PUT 修改教师招生信息

## 可视化
- [ ] 0. 绘制出大类学科中的所有研究方向网络图。

GET 发送某个大类学科，获得该学科的研究方向列表和每个研究方向的论文数。也可以获得全部学科及全部研究方向
require {subject: [String]} | null 若不发送查询字段 则返回全部学科及全部研究方向
response [
{
	subject: String,
	theme: [
		{
			name: String, 研究方向名
			count: Number 研究方向论文篇数
		}
	]
}
]

- [ ] 1. 根据导师论文的合作者，绘制出学术关系网络图

GET 发送一个导师列表，获得所有该导师的合作者及合作篇数，已经每个导师合作发文的总数。也可以获得全部老师的上述信息。
require {teacherID: [String]}
response {
	nodes: [{
		name: String, 老师姓名
		degree: Number 每个老师合作发文的总数
	}],
	edges: [{
		source: String, 老师姓名
		target: String, 老师姓名
		count: Number 合作过的篇数
	}]
}

- [ ] 2. 根据导师论文中的关键词绘制网络图。

GET 发送导师列表，获得所有该导师的论文题目、链接和去重后的关键词
require {teacherID: [String]}
response {
	nodes: [
		{
			type: Enum, 边的类型，有PAPER和KEYWORD两个选择
			name: String,
			link: String, 论文链接
		}
	],
	edges: [
		{
			type: Enum, 边的类型，有PAPER和KEYWORD两个选择
			source: String,
			target: String
		}
	]
}

- [ ] 3. 以学院被引最多的论文的关键字和作者为依据，分析不同学院的学科交叉情况。

GET 发送学院名/ID列表，获得不同学院老师合作的论文数
require {collegeID: [String]}
response {
	nodes: [
		{
			name: String,  学院名
			degree: Number
		}
	],
	edges: [
		{
			source: String,
			target: String, 二者均为学院名
			count: Number 边的权重
		}
	]
}
- [ ] 4. 分析学院历年来科研比重。
GET 发送学院名/ID列表，获得该学院历年来的科研比重(每年比重 = 被引数 / 全校被引数)
require {collegeID: [String]}
response [
	year: Number,
	percentage: Number
]



	<!-- [ ]pandoc --standalone --self-contained --css pandoc.css interface.md --output interface.html -->
