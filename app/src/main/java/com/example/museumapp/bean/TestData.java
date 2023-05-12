package com.example.museumapp.bean;

import com.example.museumapp.R;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    public static List<Collection> getCollections(){
        List<Collection> list = new ArrayList<Collection>();
        list.add(new Collection(R.drawable.c1, "青花喜字缠枝连纹双耳瓷瓶"));
        list.add(new Collection(R.drawable.c2, "酱釉玉壶瓶"));
        list.add(new Collection(R.drawable.c3, "牡丹纹瓷凤尾瓶"));
        list.add(new Collection(R.drawable.c4, "描金人物纹木书箱"));
        list.add(new Collection(R.drawable.c5, "盘龙纹天球瓶"));
        list.add(new Collection(R.drawable.c6, "铜熏炉"));
        list.add(new Collection(R.drawable.c7, "青花山水纹瓷盘"));
        list.add(new Collection(R.drawable.c8, "金漆木雕王羲之爱白鹅涂涤环板"));
        list.add(new Collection(R.drawable.c9, "金漆木雕观音"));
        list.add(new Collection(R.drawable.c10, "四方形砚"));
        return list;
    }

    public static List<New> getNews(){
        List<New> list = new ArrayList<>();
        list.add(new New(R.drawable.n1, "宁德市博物馆新馆正式开馆啦！","9月29日，闽东契约文书展暨宁德市博物馆（闽东畲族博物馆）新馆开馆活动举行。市政府副市长包江苏，市文化和旅游局党组书记、局长霍立昀出席活动。"));
        list.add(new New(R.drawable.n2, "宁德市博物馆有新“动作”！邀您体验福器拓片、制作福印书签","福文化是中华传统民俗文化的一个分支，包含了人们对世界、宇宙的理解和思考，蕴含了人们的生活理想持之以恒的奋斗精神，对幸福生活的向往，对美好未来的期盼。此次展览共精心挑选120多件福文化代表性器物，有陶瓷器、木器、竹编器、铜器等，集中反映人们吃、穿、住、用等，将福字器物归纳为直观福、图案福、图文并茂福，让观众更直接感受福字器物中深厚的福文化内涵"));
        list.add(new New(R.drawable.n3, "追寻城市记忆 传承红色基因 ——市生态环境局关工委组织参观宁德市博物馆","为深化青少年德育思想教育，引导青少年树立和践行社会主义核心价值观，坚定理想信念，进一步实现中华民族伟大复兴中国梦。4月22日上午，宁德市生态环境局关工委组织开展“追寻城市记忆 传承红色基因”主题活动，局机关及直属单位共13个家庭到宁德市博物馆参观学习。 "));
        list.add(new New(R.drawable.n4, "闽东畲族博物馆（宁德市博物馆）2021年度管理运行和公共文化服务情况","闽东畲族博物馆（宁德市博物馆）是以收藏、展示、研究宁德历史文化、畲族民俗风情为宗旨的综合性博物馆，1989年建成闽东畲族博物馆，2005年成立宁德市博物馆，实行“一套人马，两块牌子”。2009年被国家文物局评为“国家三级博物馆”。现馆址位于宁德市东侨经济开发区华庭路艺术馆大楼内。博物馆展厅面积800平方米，基本陈列分为“宁德历史”和“畲族文化”两大部分，共展出文物800多件。“宁德历史”陈列以时间为序从古遗址、古墓葬、古建筑、石刻碑记、近现代重要史迹及代表性建筑五个部分，展示宁德的悠久历史和灿烂文化。“畲族文化”陈列则展示了畲族的婚礼、不同地区不同样式的传统服饰以及生产生活习俗等面貌"));
        list.add(new New(R.drawable.n5, "龙邦博展 跨越千年“云”上相见 福建省宁德市博物馆今天开馆！","福建省宁德市博物馆是以收藏、展示、研究宁德历史文物和闽东畲族文物为宗旨的综合性博物馆，2022年馆址迁至宁德市四大馆（宁德市蕉城区东侨经济技术开发区金马北路和仙蒲交叉口，宁德市动车站对面）内。福建省宁德市博物馆设计布展施工项目由龙邦建设股份有限公司中标，工期历时180天，龙邦博展事业部秉承“传承千年精工，缔造龙邦品质”的企业精神，在公司领导及项目部的共同奋斗下，今天线上线下正式开馆。"));

        return list;
    }
}
