package com.example.techinquiri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.techinquiri.data.dbHandler;

public class MainActivity extends AppCompatActivity {

    Button skip,loginbutton,signupbutton;
    dbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new dbHandler(this);

        skip = (Button)findViewById(R.id.textButton);
        loginbutton = (Button)findViewById(R.id.loginbutton);
        signupbutton = (Button)findViewById(R.id.signupbutton);

        db.addStory("Yaksh & Pandavas", "The Story of Yaksh and Pandavas");
        db.addStory("Squirrel's Effort for RamSetu", "Squirrel's role ");
        db.addStory("Pandora's Box","Lorem Ipsum");

        db.addBranch(1,"4 Pandavas");   //1
        db.addBranch(1,"Yaksh");        //2
        db.addBranch(1,"Yudhisthir");   //3
        db.addBranch(2,"Monkeys");      //4
        db.addBranch(2,"Squirrels");    //5
        db.addBranch(2,"Lord Ram");     //6
        db.addBranch(3,"Pandora");      //7
        db.addBranch(3,"Zeus");         //8

        db.addQuestions(1,"Why the first four Pandavas behaved the wayvthey did?", "To be decided", "No",0);
        db.addQuestions(1,"How can we avoid falling for our human emotions in times of need like the 4 pandavas","To be decided","Yes",1);
        db.addQuestions(2,"How to ask highly intellectual questions like Yaksh?","to be decided","no",0);
        db.addQuestions(2,"Why is asking right question important","to be decided","no",0);
        db.addQuestions(2,"How to know what, when and how to ask?","to be decided","yes",3 );
        db.addQuestions(3,"How to stay calm amidst crisis like him?","to be decided","no",0);
        db.addQuestions(3,"How can you answer to critical questions?","to be decided","no",0);
        db.addQuestions(3,"How to read between the lines when in a conversation", "to be decided","yes",2);

        db.addQuestions(4,"Was the point of view presented by the monkeys absolutely wrong?","No, monkeys cannot be considered absolutely incorrect with regard to the context they kept forward. In the primitive ape based thinking the level of your contribution directly depends on its visible volume, which holds true if you reside in a forest. However what monkeys lacked was to have an alternative frame of mind to accept a different perspective and justify the contribution. We also despite of all the evolution give in to our primitive brain and make decisions and biases without entertaining variation in point of view which can costs us a lot! \n Imagine, what would have happened if squirrels didn’t contribute, could the bridge have been successfully completed for Lord Ram??\n","no",0);
        db.addQuestions(4,"Have a look at everyday human qualities which keeps us away from being out best!","Just like the bias for volume equals to productivity exhibited by monkeys there exists many other qualities or we can say lack of certain qualities that prevent us from exceeding our expectations.\n For example, a person who gets angry easily and looks for revenge usually does no benefit to himself or people around, rather in such a scenario it leads to self-sabotage.\n A person who never says no to anyone might seem very generous but instead it deteriorate one’s own time managing capabilities and shows a very sacrificial persona with lack of self-respect \n There are many other such qualities few of them are even highlighted in the upcoming stories, make sure you check it out!\n", "yes",1);
        db.addQuestions(5,"Just like small contributions, small changes go a long way, check how it works!", "Small efforts, contributions, errors and habits go a long way than we think they go. Every time you decide to remain consistent with your habits of exercising or eating junk, you might not see the consequences the following day but you’ll see it over time, after a time it’ll be very significant and evident.\n This happens due to a phenomenon known as compounding, let’s understand it with example of money!\n Assume a genie appears in front of you and gives you two options:\n Option 1: Take a rupee now which will get doubled each day for 30 days.\n Option 2: Take Rs. 5 Crore now\n Answer: It pays to be wise with your money and no matter how small the start, it is regular growth that matters.\n If you chose option 2, you would lose a cool Rs. 48.5 Crore. A rupee doubled becomes just Rs. 2 the second day, Rs. 4 the third day, Rs. 8 the fourth day and so on. While it seems as if it won’t amount to much, the magic happens on Day 18 when Re. 1 has grown to Rs. 1,31,072. The money now grows at a rapid pace and in the last 12 days, it goes from less than Rs. 1.5 Lakh to around Rs. 53.7 Crore.\nSo just as in the example money compounded over and over as days pass, the outcome of good and we do to ourselves also grows, and eventually seems as an overnight doing. In our story the efforts by the squirrel supplemented to those of the others. In a short-term view, one might think, adding some sand here and there couldn’t have a significant impact over the marvellous architecture, but in reality it was just as crucial as the big stones and big factor why the bridge could be erected and became safe for the travel!\n",
                "no",0);
        db.addQuestions(6,"Want to know how you can become an anclusive Leader like Lord Ram?","       Lord Ram comes to us as very inclusive leader from the story, and having such a personality can help you ace in your life as well. Question is how can we do it?\n To get started you first need to start by yourself, a good analysis of your own self, giving you an idea of what your own biases are, note them down on a paper and talk about it with people around you who can comment over it honestly\n Once you have a list of biases think about possible ways on how prevent you from thinking or knowing about something new and useful\n As this is done, you can understand how your biases keep you away from a lot of good that could have been achieved by you.\n\nDoing this exercise, gives you a clearer insight on how you are self-sabotaging your own success, and with timely repetition of this exercise, you can prevent your bias to overpower you and be more inclusive when it comes to ideas and people.","no",0);
        db.addQuestions(6,"How to be appreciative of others?","     It’s a tricky path when you think on to become appreciative of others around you and also not sound cheesy. Here are few ways you can achieve it:\n1.Every day, say aloud three good things that happened.\n2.Cool a hot temper with a quick gratitude inventory.\n3.Thank yourself. Gratitude doesn’t always need to be focused on what other people have done for you! Make sure you give yourself a thank-you for the healthy habits you’ve cultivated in your own life, such as eating plenty of veggies or giving yourself enough time for rest each night.\n4.Use technology to send three gratitude messages a week.\n5.Savour the good moments.\n6.Change your perspective.\n","yes",3);

        db.addQuestions(7,"Like Pandora, how can you make 'being curious' your strenght?","Curiosity is not only important for those with high IQs. Successful students (and people who are successful after college) often display a good measure of intellectual curiosity.\n But why is curiosity so important? Here are four reasons:\n1. It makes your mind active instead of passive: Curious people always ask questions and search for answers. Their minds are always active. Since the mind is like a muscle which becomes stronger through continual exercise, the mental exercise caused by curiosity makes your mind stronger and stronger.\n2. It makes your mind observant of new ideas: When you are curious about something, your mind expects and anticipates new ideas related to the subject. When the ideas come you will recognize them. Without curiosity, the ideas may pass right in front of you and yet you miss them because your mind is not prepared to recognize them. Just think, how many great ideas may have been lost due to lack of curiosity?\n3. It opens up new worlds and possibilities: By being curious you will be able to see new worlds and possibilities that are normally not visible. They are hidden behind the surface of normal life, and it takes a curious mind to look beneath the surface and discover these new worlds and possibilities.\n4. It brings excitement into your life: The lives of curious people are far from boring. They are neither dull nor routine. There are always new things that attract the curious person’s attention, there are always new ‘toys’ to play with. Instead of being bored, curious people have an adventurous life\n","no",0);
        db.addQuestions(7,"Should we put a limit to our curiosity?","Keeping a limit to your curiosity can be a hindrance to your growth, hence it is suggested that you don’t keep a conscious limit as our mind already has a sub conscious limit to our reasoning and ability to stay curious","no",0);
        db.addQuestions(7,"What are the best ways to get our curious self satisfied in present day scenario?","     here are some tips to develop it:\n 1. Keep an open mind: This is essential if you are to have a curious mind. Be open to learn, unlearn, and relearn. Some things you know and believe might be wrong, and you should be prepared to accept this possibility and change your mind.\n2. Don’t take things at face value. If you just accept the world as it is without trying to dig deeper, you will certainly lose the ‘holy curiosity’. Never take things at face value. Try to dig deeper beneath the surface of what is around you.\n3. Ask questions relentlessly: A sure way to dig deeper beneath the surface is asking questions: What is that? Why is it made that way? When was it made? Who invented it? Where does it come from? How does it work? What, why, when, who, where, and how are the best friends of curious people.\n4. Don’t label something as boring: Whenever you label something as boring, you close one more door of possibilities. Curious people are unlikely to call something boring. Instead, they always see it as a door to an exciting new world. Even if they don’t yet have time to explore it, they will leave the door open to be visited another time.\n5. See learning as something fun If you see learning as a burden, there’s no way you will want to dig deeper into anything. That will just make the burden heavier. But if you think of learning as something fun, you will naturally want to dig deeper. So, look at life through the glasses of fun and excitement and enjoy the learning process.\n6. Have diversity in your reading Don’t spend too much time in just one world; take a look at other worlds. It will introduce you to the possibilities and excitement of the other worlds which may spark your interest to explore them further. One easy way to do this is through reading diverse genres and topics. Try to pick a book or magazine on a new subject and let it feed your mind with the excitement of a new world\n","yes",1);
        db.addQuestions(8,"Were the gifts given by Zeus even worth gifting?"," Gifts in all forms, shape and sizes are alright if the intentions of the presenter are in the right spirits. Here in the scenario of Pandora, her father Zeus gave her two gifts which helped her accumulate her wisdom and other was a controlling stick for her to keep a check on her powers. Hence it always depends on the way in which you use what you get determines its utility.","no",0);
        db.addQuestions(8,"How can we use of what we have to our advantage?"," Making most of what you’ve got can be an excellent way to remove any regrets in your life as this gives you a sense of ownership. For start, you need to be aware of your own gifts, without it you’ll feel lost so a self-check is a must and continuous process. Then, you need to understand how you can play the available resources to your advantage as per the scenario. After understanding it you need to develop a sense of if-and-so list of ways using which you can act. And finally after every attempt you must do a check of how far you have got and what more must be done to improve things in future.","no",0);

        skip.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, StoriesHomeActivity.class);
                startActivity(intent);
            }
        });

        loginbutton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent1);
            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent2 = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent2);
            }
        });
    }
}