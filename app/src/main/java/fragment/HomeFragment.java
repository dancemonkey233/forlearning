package fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.forlearning.R;
import com.example.forlearning.adapter.HomeAdapter;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles={"《小狮子拔牙》","《聪明的小青蛙》","《小猪变老猪》","《调皮的小松鼠》","《蚂蚁报恩》"};
    private String[] contents={"森林里，住着一只馋嘴的小狮子，它一看到糖果，口水就会流下来。\n" +
            "\n" +
            "一天天过去了，小狮子吃的糖越来越多，数都数不清了。有一天小狮子突然感到牙疼，而且是疼得越来越厉害，它一边大声叫，一边在床上滚来滚去。小花猫听见了，赶快一溜烟地跑到小狮子家，一看见小狮子在床上滚来滚去，二话不说就带着小狮子去了医院。\n" +
            "\n" +
            "来到了医院，小兔医生说：“小狮子吃了太多的糖果，把牙齿都吃坏了，蛀牙拔掉就没事了。”\n" +
            "\n" +
            "小狮子张开了大嘴巴，小兔医生一拔，就把牙齿拔了下来，可小狮子还在叫：“哎哟~哎哟~”。\n" +
            "\n" +
            "小狮子伤心地对小花猫说：“小花猫，要不是你带我来医院，我都要疼死了！”它又对小兔医生说：“都是我不好，害得大家为我担心。”小狮子惭愧地低下了头。\n" +
            "\n" +
            "从那时起，小狮子就不像以前那样，整天吃糖果了。因为它知道吃太多糖会让牙齿都坏掉的。"

            ,"有一只小青蛙，生来就呆在一口既黑暗又潮湿的井里，它很想跳出井去外面看看那里的世界，也想在外面交个朋友，可它却办不到，为什么呢？因为井太深了，它怎么也跳不上去。\n" +
            "\n" +
            "有一天，一只小鸟飞到井底来喝水。小鸟喝完了水，和青蛙聊起来。小鸟惊奇地问：“你是谁呀？我怎么没见过你？”小青蛙无精打采地说：“我是青蛙，你呢？”小鸟说：“我是小鸟，你生活在这么差的地方，你不觉得孤单吗？”小青蛙抖抖身子说：“孤单。”小鸟拍了拍翅膀，说：“要不，我把你送到外面看看吧。”小青蛙一听要去外面，高兴地跳来跳去，它连忙对小鸟说：“好的，好的。”\n" +
            "\n" +
            "小青蛙就这样到了一个新家——小鸟家那棵树下面的池塘里。它住了几天，发现小鸟这几天一直闷闷不乐。于是就去问小鸟：“小鸟，你为什么这么不高兴呀，有什么心事吗？”小鸟告诉它，这里有狮子和老虎，而它们一天要吃掉一个小动物。因为大家都没有办法，所以只好被吃掉。小青蛙想了想，眼珠子一转，告诉了小鸟一个办法，办法是这样的：由兔子把小青蛙住过的井口铺上一些草作伪装，之后在井口上面放一大块肉，然后，让兔子对狮子或老虎说：“我那里有很多的肉，你只要走几步路就可以享受一顿美味大餐了。”\n" +
            "\n" +
            "大家一试，果然有效，狮子和老虎都被困在了井下，小动物们都夸小青蛙是个聪明的孩子。小青蛙听了，心里甜丝丝的。"

            ,"小猪和小马是邻居，小猪吃饱了就睡，睡够了就玩，而小马却忙着干活，拉起车就跑。\n" +
            "\n" +
            "一天，小猪问小马：“你为什么这样忙？”\n" +
            "\n" +
            "小马说：“我要趁年轻多干些，不能让时间白白流走。”\n" +
            "\n" +
            "小猪问：“时间是什么东西？”\n" +
            "\n" +
            "小马说：“时间虽然看不见，摸不着，可是它总在不停地走。钟表上的短针走一格，就是一小时；日历撕下一张就是一天。”\n" +
            "\n" +
            "小猪想，我要把时间留住。于是，它把日历锁进箱子，又取下石英钟的电池，不让钟表再走。很快新年到了，大家都换上新衣，开联欢会庆祝。\n" +
            "\n" +
            "小马问小猪：“你怎么没有过年的样子？”\n" +
            "\n" +
            "小猪说：“我家的时间才3月1号呢！”\n" +
            "\n" +
            "时间过得飞快，过了几年小猪和小马都老了。\n" +
            "\n" +
            "老猪就去问老马：“我家的时间都不走了，我怎么还会老？”\n" +
            "\n" +
            "老马说：“没有人能留住时间的。”\n" +
            "\n" +
            "老猪望着老马取得的成绩而自己什么也没干，非常后悔，可是已经晚了。\n"

            ,"小松鼠的家住在高楼里，小松鼠总是喜欢跳到窗户上去玩。\n" +
            "\n" +
            "松鼠妈妈看到小松鼠的这种举动，非常担心，它对小松鼠说：“小松鼠快下来，那很危险，不能跳到窗户上去玩，会摔下去的。”\n" +
            "\n" +
            "小松鼠说：“没关系的妈妈，我不会摔下去的。”\n" +
            "\n" +
            "一阵大风吹过，小松鼠一个没站稳，跌在了妈妈的怀里。\n" +
            "\n" +
            "小松鼠吓得直发抖，松鼠妈妈说：“看吧！多危险，如果不小心跌到了窗户外面，后果是很严重的，会危害到我们的生命安全。”\n" +
            "\n" +
            "小松鼠点头说：“妈妈，我知道错了，以后再也不会爬窗户了。”"

            ,"蚂蚁赶路走累了，刚好路过一个池塘。\n" +
            "\n" +
            "它走到池塘边，想喝水，休息休息，可一不小心，滑进了水中。“救命啊，救……救救我！”\n" +
            "\n" +
            "蚂蚁不会游泳，呛了好几口水，挣扎着呼救。\n" +
            "\n" +
            "池塘边有棵大树，树上站着一只鸽子。\n" +
            "\n" +
            "它听到蚂蚁的呼救声，探出头来一看：哎呀，蚂蚁掉到水里去了！\n" +
            "\n" +
            "鸽子想救蚂蚁，可自己也不会游泳，这可怎么办呢？\n" +
            "\n" +
            "它急中生智，摘下一大片树叶，丢给蚂蚁说：“快，快爬到树叶上来！”\n" +
            "\n" +
            "蚂蚁赶紧抓住树叶，爬了上去，它得救了！\n" +
            "\n" +
            "蚂蚁对鸽子说：“鸽子先生，谢谢你救了我的命，以后有机会，我一定报答你！”\n" +
            "\n" +
            "几天后的中午，蚂蚁看见鸽子在树上睡午觉。它很想和鸽子打招呼，又怕打扰它的休息，于是就准备走开。\n" +
            "\n" +
            "这时，蚂蚁忽然听到一阵“沙沙”的脚步声。\n" +
            "\n" +
            "不一会儿，一个猎人出现了，他发现了路上的鸽子就张弓搭箭，向树上的鸽子瞄准。\n" +
            "\n" +
            "喊叫已经来不及了，刚好猎人的脚就在蚂蚁的旁边，蚂蚁张开嘴，在猎人脚上狠狠地咬了一口。\n" +
            "\n" +
            "猎人正要放箭，忽然感到脚指上一阵刺痛，身子一晃，那支箭“嗖”地一声，射偏了，钉在树干上了。\n" +
            "\n" +
            "蚂蚁趁机大喊：“鸽子快跑，有危险！”\n" +
            "\n" +
            "鸽子吓了一跳，慌忙展翅飞走了。\n" +
            "\n" +
            "猎人拔腿就追，可他哪追得上鸽子呐，只好垂头丧气地离开了。\n" +
            "\n" +
            "过了一会儿，鸽子飞回来，对蚂蚁表示感谢。\n" +
            "\n" +
            "蚂蚁说：“我也很高兴，因为我终于有机会报答你的救命之恩了！”"};
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;
    public HomeFragment() {

    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragment_home, container, false);
       viewPager=v.findViewById(R.id.fixedViewPager);
        slidingTabLayout=v.findViewById(R.id.slidingTabLayout);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for(String content:contents){
            mFragments.add(VideoFragment.newInstance(content));
        }
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.setAdapter(new HomeAdapter(getFragmentManager(),mTitles,mFragments));
        slidingTabLayout.setViewPager(viewPager);

    }
}