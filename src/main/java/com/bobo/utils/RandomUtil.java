package com.bobo.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

/**
 * 
 * @ClassName: RandomUtil
 * @Description: 随机数工具类
 * @author: charles
 * @date: 2020年6月22日 上午9:33:06
 */
public class RandomUtil {
	
	/**
	 * 
	 * @Title: randomDate 
	 * @Description: 返回在min-max之间的随机日期
	 * @param min
	 * @param max
	 * @return
	 * @return: Date
	 */
	public static Date randomDate(Date min,Date max) {
		long t1 = min.getTime();//从1970到min 的毫秒值
		long t2 = max.getTime();//从1970到max 的毫秒值
		double d = Math.random();//产生一个0-1之间值
		
		long t = (long) (d * (t2 -t1 +1) + t1);//得到 t1 -t2之间的毫秒值
		
		return new Date(t);
		
	}
	
	

	/**
	 * 功能：获取随机正整数
	 *
	 * @return int 正整数
	 */
	public static int nextInt() {
		Random r = new Random();
		return Math.abs(r.nextInt());
	}

	/**
	 * 功能：获取指定最大范围的随机正整数 示例：max=5，那么返回0-5(包括5)之间任意一个数
	 *
	 * @param int max 最大范围，要包含最大范围值。
	 * @return 随机数
	 */
	public static int nextInt(int max) {

		Random r = new Random();

		return r.nextInt(max + 1);// r.nextInt（5）返回 0=<x<5 的范围的值
	}

	/**
	 * 功能：获取指定最大范围的随机正整数 示例：min=5,max=10，那么返回5-10(包括5和10)之间任意一个数
	 *
	 * @param int min 最小范围，要包含最小范围值。
	 * @param int max 最大范围，要包含最大范围值。
	 * @return 随机数
	 */
	public static int nextInt(int min, int max) {
		Random r = new Random();
		// 0,1,2,3,4,5 5
		return r.nextInt(max - min + 1) + min;
	}

	/**
	 * 功能：在最小值与最大值之间截取随机数 场景：在List集合中截取多个的随机记录。
	 * 
	 * 5 -10 没有重复的三个3值 567 556 789 778 788
	 *
	 * @param int min 起始值。
	 * @param int max 结束值。
	 * @return 多个随机数
	 */
	public static int[] subIntegers(int min, int max, int subLength) {

		int[] x = new int[subLength];//定义数组用来存放结果值
		//定义set集合用来过滤重复数据
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size()!=subLength) {
			set.add(nextInt(min,max));
		}
		//把set转数组
		int i=0;
		for (Integer integer : set) {
		   x[i]=integer;
		   i++;
		}
		return x;
	}

	/**
	 * 功能：获取1-9,a-Z之间的随机字符，即包括数字或字母(含大小写)的字符
	 *
	 * @return 随机字符
	 */
	public static char nextCharacter() {
		String str="123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		return str.charAt(nextInt(str.length() -1));
	}

	/**
	 * 功能：获取指定长度的随机字符数 场景：创建验证码
	 *
	 * @param int length 长度。
	 * @return 随机字符串
	 */
	public static String nextString(int length) {
		StringBuffer sb =new StringBuffer();
		for (int i = 0; i <length; i++) {
			sb.append(nextCharacter());
		}
		return sb.toString();
	}

	/**
	 * 功能：获取一个随机中文字符
	 *
	 * @return 随机简体中文字符
	 */
	public static String nextSimplifiedChineseCharacter() {
		 String str = null;
	        int highPos, lowPos;
	        Random random = new Random();
	        
	        highPos = (176 + random.nextInt(40) );//区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
	        random=new Random();
	        //如果random.nextInt(40)=39 ，则是55区，因为55区， 只有90个汉字，所以需要特殊处理一下
	        //49+176=215
	        if(highPos==215)
	        lowPos=160+89;
	        else {
	        lowPos = 160+ RandomUtil.nextInt(1,94);//位码，0xA0打头，范围第1~94列
	        }
	        byte[] bArr = new byte[2];//一个简体中文是有2个字节组成
	        bArr[0] = (new Integer(highPos)).byteValue();
	        bArr[1] = (new Integer(lowPos)).byteValue();
	        try {
	            str = new String(bArr, "GB2312");   //区位码组合成汉字
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        
	            return str;
	}

	/**
	 * 功能：获取指定长度的随机中文字符串
	 *
	 * @param int length 长度
	 * @return 随机简体中文字符串
	 */
	public static String nextSimplifiedChineseString(int length) {
		StringBuffer sb= new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(nextSimplifiedChineseCharacter());
		}
		return sb.toString();
		   
	    }

	/**
	 * 功能：创建一个中文姓名
	 *
	 * @return 人名
	 */
	public static String generateChinesePersonName() {
		

	     String[] surname = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
	              "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云",
	              "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍",
	              "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时",
	              "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵", "湛", "汪",
	              "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈", "项",
	              "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛",
	              "林", "刁", "钟", "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管", "卢",
	              "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石",
	              "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊", "于", "惠", "甄", "曲", "家", "封", "芮",
	              "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山", "谷", "车", "侯",
	              "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "钭", "厉", "戎", "祖", "武", "符",
	              "刘", "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "溥", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂",
	              "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党", "翟", "谭",
	              "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "却", "璩", "桑", "桂", "濮", "牛", "寿", "通", "边", "扈",
	              "燕", "冀", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦", "艾", "鱼", "容",
	              "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广",
	              "禄", "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖", "融", "冷", "訾",
	              "辛", "阚", "那", "简", "饶", "空", "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查", "后", "荆",
	              "红", "游", "郏", "竺", "权", "逯", "盖", "益", "桓", "公", "仉", "督", "岳", "帅", "缑", "亢", "况", "郈", "有", "琴", "归",
	              "海", "晋", "楚", "闫", "法", "汝", "鄢", "涂", "钦", "商", "牟", "佘", "佴", "伯", "赏", "墨", "哈", "谯", "篁", "年", "爱",
	              "阳", "佟", "言", "福", "南", "火", "铁", "迟", "漆", "官", "冼", "真", "展", "繁", "檀", "祭", "密", "敬", "揭", "舜", "楼",
	              "疏", "冒", "浑", "挚", "胶", "随", "高", "皋", "原", "种", "练", "弥", "仓", "眭", "蹇", "覃", "阿", "门", "恽", "来", "綦",
	              "召", "仪", "风", "介", "巨", "木", "京", "狐", "郇", "虎", "枚", "抗", "达", "杞", "苌", "折", "麦", "庆", "过", "竹", "端",
	              "鲜", "皇", "亓", "老", "是", "秘", "畅", "邝", "还", "宾", "闾", "辜", "纵", "侴", "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛",
	              "闻人", "东方", "赫连", "皇甫", "羊舌", "尉迟", "公羊", "澹台", "公冶", "宗正", "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕",
	              "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "兀官", "司寇", "南门", "呼延", "子车", "颛孙", "端木", "巫马", "公西",
	              "漆雕", "车正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "微生", "梁丘", "左丘", "东门", "西门", "南宫", "第五",
	              "公仪", "公乘", "太史", "仲长", "叔孙", "屈突", "尔朱", "东乡", "相里", "胡母", "司城", "张廖", "雍门", "毋丘", "贺兰", "綦毋", "屋庐", "独孤",
	              "南郭", "北宫", "王孙" };
		
	     
	     String name1 = surname[RandomUtil.nextInt(surname.length-1)];//获取姓氏
		 String name2 = nextSimplifiedChineseString(RandomUtil.nextInt(1,2));//随机产生名字
		return name1 +name2;
	}

	/**
	 * 功能：获取不带横线的UUID 场景：上传文件时作为新文件名
	 *
	 * @return 不带横线的UUID
	 */
	public static String uuid() {
		String str = UUID.randomUUID().toString();
		return str.replace("-", "");
	}
}
