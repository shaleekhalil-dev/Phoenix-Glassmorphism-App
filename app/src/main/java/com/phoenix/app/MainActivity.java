package com.phoenix.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private boolean isArabic = false;
    private LinearLayout containerProfile, containerPhilosophy, containerStations, containerExercises, containerAboutBook;
    private Button tabProfile, tabPhilosophy, tabStations, tabExercises, tabAboutBook, btnLangToggle, btnReadBook, btnPortfolio, btnBook, btnSend;
    private CardView cardContactForm;

    private TextView coachTitle, coachSubtitle, coachBio, tvPhTitle, tvPhBody, tvContactTitle, tvPracticalManualTitle, tvBookConceptTitle, tvBookConceptBody;
    private TextView stTitle1, stDesc1, stTitle2, stDesc2, stTitle3, stDesc3, stTitle4, stDesc4, stTitle5, stDesc5;
    private TextView exTitle1, exClick1, exTitle2, exClick2, exTitle3, exClick3, exTitle4, exClick4, exTitle5, exClick5, exTitle6, exClick6;
    private CardView exCard1, exCard2, exCard3, exCard4, exCard5, exCard6;

    private EditText etFullName, etMessage;
    private ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        containerProfile = findViewById(R.id.container_profile);
        containerStations = findViewById(R.id.container_stations);
        containerPhilosophy = findViewById(R.id.container_philosophy);
        containerExercises = findViewById(R.id.container_exercises);
        containerAboutBook = findViewById(R.id.container_about_book);
        cardContactForm = findViewById(R.id.card_contact_form);

        tabProfile = findViewById(R.id.tab_profile);
        tabStations = findViewById(R.id.tab_stations);
        tabPhilosophy = findViewById(R.id.tab_philosophy);
        tabExercises = findViewById(R.id.tab_exercises);
        tabAboutBook = findViewById(R.id.tab_about_book);
        btnLangToggle = findViewById(R.id.btn_lang_toggle);

        profileImage = findViewById(R.id.profile_image);
        coachTitle = findViewById(R.id.coach_title_text);
        coachSubtitle = findViewById(R.id.coach_subtitle_text);
        coachBio = findViewById(R.id.coach_bio_text);
        btnReadBook = findViewById(R.id.btn_read_book);
        btnPortfolio = findViewById(R.id.btn_profile);
        btnBook = findViewById(R.id.btn_book);

        tvPracticalManualTitle = findViewById(R.id.tv_practical_manual_title);
        tvPhTitle = findViewById(R.id.tv_ph_title);
        tvPhBody = findViewById(R.id.tv_ph_body);
        tvBookConceptTitle = findViewById(R.id.tv_book_concept_title);
        tvBookConceptBody = findViewById(R.id.tv_book_concept_body);
        tvContactTitle = findViewById(R.id.tv_contact_title);
        etFullName = findViewById(R.id.etFullName);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btn_send);

        stTitle1 = findViewById(R.id.st_title_1); stDesc1 = findViewById(R.id.st_desc_1);
        stTitle2 = findViewById(R.id.st_title_2); stDesc2 = findViewById(R.id.st_desc_2);
        stTitle3 = findViewById(R.id.st_title_3); stDesc3 = findViewById(R.id.st_desc_3);
        stTitle4 = findViewById(R.id.st_title_4); stDesc4 = findViewById(R.id.st_desc_4);
        stTitle5 = findViewById(R.id.st_title_5); stDesc5 = findViewById(R.id.st_desc_5);

        exCard1 = findViewById(R.id.ex_card_1); exTitle1 = findViewById(R.id.ex_title_1); exClick1 = findViewById(R.id.ex_click_1);
        exCard2 = findViewById(R.id.ex_card_2); exTitle2 = findViewById(R.id.ex_title_2); exClick2 = findViewById(R.id.ex_click_2);
        exCard3 = findViewById(R.id.ex_card_3); exTitle3 = findViewById(R.id.ex_title_3); exClick3 = findViewById(R.id.ex_click_3);
        exCard4 = findViewById(R.id.ex_card_4); exTitle4 = findViewById(R.id.ex_title_4); exClick4 = findViewById(R.id.ex_click_4);
        exCard5 = findViewById(R.id.ex_card_5); exTitle5 = findViewById(R.id.ex_title_5); exClick5 = findViewById(R.id.ex_click_5);
        exCard6 = findViewById(R.id.ex_card_6); exTitle6 = findViewById(R.id.ex_title_6); exClick6 = findViewById(R.id.ex_click_6);

        if (profileImage != null) {
            profileImage.setImageResource(R.mipmap.book_cover);
        }

        tabProfile.setOnClickListener(v -> switchTab(1));
        tabStations.setOnClickListener(v -> switchTab(2));
        tabPhilosophy.setOnClickListener(v -> switchTab(3));
        tabExercises.setOnClickListener(v -> switchTab(4));
        tabAboutBook.setOnClickListener(v -> switchTab(5));

        btnLangToggle.setOnClickListener(v -> {
            isArabic = !isArabic;
            updateAppLanguage();
        });

        btnPortfolio.setOnClickListener(v -> openWebUrl("https://shaleekhalil-dev.github.io/shalee-khalil-portfolio/"));
        btnBook.setOnClickListener(v -> openWebUrl("https://api.whatsapp.com/send/?phone=970599661819&text&type=phone_number&app_absent=0"));

        btnReadBook.setOnClickListener(v -> {
            if (isArabic) {
                openWebUrl("https://drive.google.com/file/d/1EUNItc73f-SkvPGQMnrLUkpTBsa8ZQu-/preview");
            } else {
                openWebUrl("https://drive.google.com/file/d/1IgnL_NNntUgw4hTreTBJeKowaqYrWCjK/preview");
            }
        });

        btnSend.setOnClickListener(v -> {
            String name = etFullName.getText().toString().trim();
            String message = etMessage.getText().toString().trim();
            if (name.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, isArabic ? "يرجى ملء جميع الحقول" : "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"shaaleekhalil@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Phoenix App Inquiry from: " + name);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(intent, "Send Email..."));
        });

        setupExerciseClickListeners();
        updateAppLanguage();
    }

    private void switchTab(int tabIndex) {
        containerProfile.setVisibility(tabIndex == 1 ? View.VISIBLE : View.GONE);
        containerStations.setVisibility(tabIndex == 2 ? View.VISIBLE : View.GONE);
        containerPhilosophy.setVisibility(tabIndex == 3 ? View.VISIBLE : View.GONE);
        containerExercises.setVisibility(tabIndex == 4 ? View.VISIBLE : View.GONE);
        containerAboutBook.setVisibility(tabIndex == 5 ? View.VISIBLE : View.GONE);

        // التحكم برؤية استمارة التواصل (تظهر في التبويب 1 و 5 فقط وتختفي في 2 و 3 و 4)
        if (cardContactForm != null) {
            cardContactForm.setVisibility((tabIndex == 1 || tabIndex == 5) ? View.VISIBLE : View.GONE);
        }

        tabProfile.setBackgroundTintList(android.content.res.ColorStateList.valueOf(tabIndex == 1 ? 0xA0FFFFFF : 0x40FFFFFF));
        tabStations.setBackgroundTintList(android.content.res.ColorStateList.valueOf(tabIndex == 2 ? 0xA0FFFFFF : 0x40FFFFFF));
        tabPhilosophy.setBackgroundTintList(android.content.res.ColorStateList.valueOf(tabIndex == 3 ? 0xA0FFFFFF : 0x40FFFFFF));
        tabExercises.setBackgroundTintList(android.content.res.ColorStateList.valueOf(tabIndex == 4 ? 0xA0FFFFFF : 0x40FFFFFF));
        tabAboutBook.setBackgroundTintList(android.content.res.ColorStateList.valueOf(tabIndex == 5 ? 0xA0FFFFFF : 0x40FFFFFF));
    }

    private void openWebUrl(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    private void updateAppLanguage() {
        tabProfile.setText(isArabic ? "الحساب الشخصي" : "Profile");
        tabStations.setText(isArabic ? "المحطات العمرية" : "The 5 Stations");
        tabPhilosophy.setText(isArabic ? "فلسفة التدريب" : "Philosophy");
        tabExercises.setText(isArabic ? "التمارين التفاعلية" : "Exercises");
        tabAboutBook.setText(isArabic ? "عن الكتاب وفكرته" : "About Book");

        tvPracticalManualTitle.setText(isArabic ? "دليل التنفيذ العملي الشامل" : "Practical Instruction Manual");
        tvContactTitle.setText(isArabic ? "نافذة التواصل مع الكوتش" : "Contact Window");
        btnSend.setText(isArabic ? "إرسال البيانات" : "Send Message");
        etFullName.setHint(isArabic ? "الاسم الكامل" : "Full Name");
        etMessage.setHint(isArabic ? "رسالتك الكريمة" : "Your Message");

        coachTitle.setText(isArabic ? "شعلي خليل" : "Coach Shalee Khalil");
        coachSubtitle.setText(isArabic ? "مطور شامل بروح أديب وموجه روحي" : "Full Stack Developer with a Writer Soul");
        coachBio.setText(isArabic ? "أنا مطور شامل بروح أديب؛ إنسان لا يكتفي بفهم البرمجيات، بل يسعى لفهم من يستخدمها أيضاً. أجمع بين ذكاء التكنولوجيا وعمق النفس البشرية، لأبني حلولاً رقمية بلمسة إنسانية ببساطة المزيج الذي يربط بين عالم الأرقام وعالم المشاعر. هدفي الأساسي أنسنة بيئات العمل الرقمية باستخدام الذكاء الاصطناعي لتطوير رأس المال النفسي. أعمل كمدرب حياة، مدرب روحي، وممارس في التسويق والإحصاء لخلق بيئات عمل مرنة ومبتكرة، ومساعدة الأفراد على انتزاع استحقاقهم وتطهير جروح الماضي للنهوض الشامخ كالبطل المنتصر لا الضحية المكسورة." : "A hybrid strategic leader and full-stack software engineer with a writer's soul, integrating engineering expertise with future technologies and behavioral sciences. Holding Google professional suite and deep certifications in Trauma and Anxiety Psychology, Psychological First Aid, and Positive Psychiatry. As a life coach and spiritual mentor, my core mission is humanizing digital structures and maximizing psychological capital to build flexible environments, guiding individuals to reclaim their discarded dignity, purify lingering trauma, and stand solid like a victorious hero instead of a suppressed victim.");
        btnReadBook.setText(isArabic ? "اقرأ الكتاب كاملاً" : "Read Full Book");

        stTitle1.setText(isArabic ? "المحطة الأولى: من عمر 4 سنوات إلى 11 سنة (الطفولة)" : "Phase One: Age 4 to 11 (Childhood Stage)");
        stDesc1.setText(isArabic ? "مرحلة الطفولة المبكرة والابتدائية: العودة إلى تلك الروح الصغيرة في رياض الأطفال أو المدرسة الابتدائية، والوقوف بجانبها لحمايتها من أي ظلم أو إهانة لم تكن تستحقها. تركز هذه المحطة على نبش التشكيل الهيكلي الأول للأمان والانتماء قبل تدخل أصوات العالم الخارجي ومواجهة الصدمات الأولى العالقة في الذاكرة لتطهيرها من الجذور وتأمين براءة البدايات." : "Returning to that small spirit in kindergarten or primary school, standing by them to protect them from any injustice or humiliation they did not deserve. This stage focuses on unearthing the early structural formations of identity, family dynamics, and the safe boundaries of childhood before the world intrudes, formatting the subconscious safety layer.");

        stTitle2.setText(isArabic ? "المحطة الثانية: من عمر 11 سنة إلى 18 سنة (المراهقة)" : "Phase Two: Age 11 to 18 (Adolescence Stage)");
        stDesc2.setText(isArabic ? "مرحلة المراهقة، الإعدادية والثانوية: إعادة صياغة مواقف التهميش أو التنمر التي مررت بها سابقاً، ومنح مراهقك القديم الكلمات والقوة والجرأة التي كان يفتقدها ليدافع عن كرامته واستحقاقه. التنقل الواعي بين محطات اضطرابات المشاعر العاصفة وتأمين ثقة وصوت مستقل يطرد الهشاشة النفسية." : "Re-formulating situations of marginalization or bullying, and giving your old adolescent self the words and strength they lacked to defend their dignity. Navigating emotional turbulence, intellectual awakening, and secondary educational pressures while establishing absolute personal sovereignty and boundary control.");

        stTitle3.setText(isArabic ? "المحطة الثالثة: من عمر 18 سنة إلى 25 سنة (الشباب)" : "Phase Three: Age 18 to 25 (University Stage)");
        stDesc3.setText(isArabic ? "المرحلة الجامعية وبداية صدمات الواقع الحتمية: مراجعة القرارات والصدمات الأولى في معترك الحياة المهنية والعاطفية، وإعادة رسمها بمنظور الشخص الواعي الذي يعرف قيمته واستحقاقه العالي. مواجهة تداعي أوهام مرحلة الطفولة والتحرر التام والكامل من أسر الأوجاع والمشاعر المكتومة والخذلان." : "Reviewing decisions and early shocks in the battlefield of life, and redrawing them from the perspective of an aware person who knows their value and worthiness. Breaking free from old illusions, experiencing the crushing weight of existential changes and initial life setbacks, transforming pain into solid wisdom.");

        stTitle4.setText(isArabic ? "المحطة الرابعة: من عمر 25 سنة إلى 30 سنة (الهوية)" : "Phase Four: Age 25 to 30 (Structural Identity)");
        stDesc4.setText(isArabic ? "مرحلة تكوين الهوية المهنية والاجتماعية: التعامل مع صدمات الواقع وتحديات بيئات العمل والمسؤوليات الكبرى، وتصحيح الرواية حول الإخفاقات بجعلها دروساً صقلت هذا البناء العظيم. هندسة المسؤوليات واختبار مرونة وقوة رأس المال النفسي التكاملي لبناء الذات الصلبة التي تأبى السقوط والانكسار." : "Dealing with reality's shocks and responsibilities, and correcting the narrative about failures by making them lessons that polished this great building. Building a career, navigating workplace environments, testing psychocapital strengths, and solidifying the operational matrix of the resilient inner home.");

        stTitle5.setText(isArabic ? "المحطة الخامسة: من عمر 30 سنة إلى 35 سنة+ (النضج)" : "Phase Five: Age 30 to 35+ (Sovereign Maturity)");
        stDesc5.setText(isArabic ? "مرحلة النضج ومواجهة الحقائق الكبرى: الوصول إلى حالة الثبات الانفعالي الكامل في مواجهة تحديات الحياة الشرسة، وتحويل الصدمات القديمة إلى دروس قيادية واعية. اليقين السيادي الكامل وإطلاق بروتوكول طائر الفينيق لإعادة البناء الشامل والنهوض فوق الرماد لتعيش حراً ومستقلاً تماماً." : "Reaching a state of full Emotional Stability in the face of life's challenges, turning old traumas into leadership lessons. Reaching absolute clarity, facing inner truths, and initiating the complete Phoenix rebuilding protocol, allowing the soul to fly permanently over the ashes of historical limitations.");

        tvPhTitle.setText(isArabic ? "فلسفة التعديل وهدم الذات المزيفة" : "The Paradigm of Demolition and Lofty Reconstruction");
        tvPhBody.setText(isArabic ? "إن فلسفتنا التدريبية والسلوكية مستوحاة بالكامل من كتاب طائر الفينيق، وتقوم على مبدأ أساسي: الهدم والبناء عمليتان مكملتان لبعضهما البعض. لا يمكن لروحك أن تشيد صرحاً جديداً شامخاً ومستقراً وهي لا تزال تقف فوق أنقاض قديمة مليئة بثقوب الصدمات والذكريات السامة. الهدم هنا ليس فعلاً عشوائياً، بل هو عملية هندسية مدروسة تهدف إلى إزالة الذات المزيفة وتفكيك الأفكار والقيود التي زرعها الآخرون فيك مثل أنا ضعيف أو أنا لا أستحق، وتعطيل نظام التشغيل القديم القائم على الخوف والقلق كآليات نجاة منتهية الصلاحية. بمجرد تنظيف الأرضية تماماً عبر نبش الماضي وحرق أوراقه الجانبية، نبدأ فوراً في وضع اللبنات الأولى لـ الذات الحقيقية المتشافية، القائمة على أسس من الوعي العالي، والصلابة والهدوء واليقين الذي لا تهزه رياح العالم، مما يوفر لك وطناً داخلياً آمناً يمنحك الاستغناء السيادي الكامل عن تقييم أو اعتذار الآخرين." : "The core philosophy of this structural coaching model is based on a foundational rule: Demolition and building are two complementary processes. Your soul cannot build a new stable Lofty structure while standing on ruins full of old trauma holes and toxic memories. Demolition is a calculated engineering process aiming to remove the False Self, dismantling alien ideas planted by others (like 'I am weak' or 'I don't deserve'), and disabling old expired defense behaviors. Once the ground is deep-cleaned by unearthing the past and burning its papers of pain, we start laying the first bricks of the healed True Self. This new building is based on high awareness, absolute honesty with self, and a bulletproof mindset that storms cannot shake, providing an inner homeland where you feel safety and tranquility, away from the world's noise and the past's tensions.");

        String actionText = isArabic ? "اضغط لعرض دليل التنفيذ العملي الشامل..." : "Tap to view full practical execution manual...";
        exTitle1.setText(isArabic ? "1. تمرين خلوة الروح والإنصات" : "1. Soul Solitude and Attunement"); exClick1.setText(actionText);
        exTitle2.setText(isArabic ? "2. تمرين نبش الجذور وسلسلة الحياة" : "2. Unearthing Roots Matrix"); exClick2.setText(actionText);
        exTitle3.setText(isArabic ? "3. تمرين إعادة الهيكلة والمنقذ الداخلي" : "3. Restructuring & Inner Savior"); exClick3.setText(actionText);
        exTitle4.setText(isArabic ? "4. بروتوكول الفجر السيادي الصباحي" : "4. The Sovereign Dawn Protocol"); exClick4.setText(actionText);
        exTitle5.setText(isArabic ? "5. الاقتحام المنظم والسيادة البدنية" : "5. Organized Incursion & Sovereignty"); exClick5.setText(actionText);
        exTitle6.setText(isArabic ? "6. سيادة الامتنان وعقلية المشاهد الميدانية" : "6. Sovereign Gratitude Observer"); exClick6.setText(actionText);

        tvBookConceptTitle.setText(isArabic ? "كتاب طائر الفينيق: عندما نشرق من جديد" : "The Concept of The Phoenix: When We Shine Again");
        tvBookConceptBody.setText(isArabic ? "يمثل هذا الكتاب دليلاً هندسياً وعلاجياً متكاملاً للروح، يهدف إلى نقل القارئ رسميًا من حقبة الضحية المستسلمة للألم إلى عصر البطل الشامخ والمتشافي الصامد. يعالج الكتاب مشكلة بقاء الصدمات داخل الروح باعتبارها رصاصة مسمومة تعيق الحركة وتفسد الحاضر، ويقدم آليات عملية وتطبيقية مجربة للعبور فوق جسر الألم والدمار نحو شواطئ اليقين والسكون الاستراتيجي. الكتاب يعلمك كيف تعيش كمؤلف وحيد لقصتك تمتلك القلم والقرار، وتتحكم في نظام تشغيلك العصبي والنفسي بعيداً عن أشباح الماضي أو ضجيج الآخرين، لتنطلق في الحياة بيقين المؤمنين بأن القادم أجمل وأرقى تليق بصبرك." : "The Phoenix serves as an engineering manual for the soul, designed to guide readers across the bridge of pain and destruction toward stillness and absolute certainty. Treating untreated trauma as a trapped bullet that poisons the present, the book introduces concrete psychological tactics to install a new operating system rooted in personal wisdom and emotional stability. It empowers you to live as the sole author of your reality, holding both the pen and the decision to construct an inner homeland resilient to collapse, ensuring that the Phoenix within you never returns to burn in the fires of the past.");
    }

    private void setupExerciseClickListeners() {
        exCard1.setOnClickListener(v -> showCustomPhoenixDialog(1));
        exCard2.setOnClickListener(v -> showCustomPhoenixDialog(2));
        exCard3.setOnClickListener(v -> showCustomPhoenixDialog(3));
        exCard4.setOnClickListener(v -> showCustomPhoenixDialog(4));
        exCard5.setOnClickListener(v -> showCustomPhoenixDialog(5));
        exCard6.setOnClickListener(v -> showCustomPhoenixDialog(6));
    }

    private void showCustomPhoenixDialog(int id) {
        String title = ""; String msg = "";
        if (isArabic) {
            switch(id) {
                case 1: title = "1. تمرين خلوة الروح والإنصات"; msg = "بروتوكول الإنصات: اترك هاتفك في غرفة أخرى، اجلس في مكان هادئ، وأغمض عينيك. لا تحاول التفكير in شيء، فقط استمع لضربات قلبك وضيق صدرك أو اتساعه. اسأل روحك: 'بماذا تشعرين الآن؟' ولا تصحح الإجابة أو تجملها، اتركها تخرج خائفة، متعبة، غاضبة، أو حتى ضائعة. خصص 10 دقائق يومياً لتجاوز ضجيج العالم الخارجي والعودة للذات."; break;
                case 2: title = "2. تمرين نبش الجذور وسلسلة الحياة"; msg = "نبش الجذور وتفريغ الأوجاع: قم بتدوين أحداث حياتك بالتفصيل ضمن المحطات السباعية في الدفتر الجديد. استخدم ورقة جانبية موازية لصب المشاعر اللحظية السامة (الخوف، القهر، الخذلان) ثم قم بحرق هذه الأوراق الجانبية فوراً لإرسال رسالة تحرر وحرية كاملة لعقلك الباطن وإعدام الماضي ومخلفاته."; break;
                case 3: title = "3. تمرين إعادة الهيكلة والمنقذ الداخلي"; msg = "استدعاء الذات الكبيرة: اختر موقفاً مؤلماً عالقاً في الذاكرة. تخيل المشهد بكل تفاصيله (المكان، الأصوات، الوجوه)، ثم ادخل بصفتك نسختك الحالية القوية الواعية كحائل يحمي طفلك أو مراهقك القديم، واحتضنه بقوة واعداً إياه بالحماية التامة والانتصار واسترداد الحق الذاتي المهدور."; break;
                case 4: title = "4. بروتوكول الفجر السيادي الصباحي"; msg = "البرمجة العصبية الصباحية: تحكم في الساعة الأولى من يومك وسكون ما قبل ضجيج العالم. ابدأ بتمارين تنفس عميقة لتهدئة الجهاز العصبي، ثم اقرأ بنود دستور استحقاقك العريق ورسالة الاعتزاز بالذات بصوت مسموع لترسيخ نظام التشغيل الجديد وحماية بنائك الشامخ من نوبات الهلع والتوتر الصباحي."; break;
                case 5: title = "5. الاقتحام المنظم والسيادة البدنية"; msg = "تغيير كيمياء الجسد: اكسر زنزانة منطقة الراحة المريحة والوهمية التي فرضتها الصدمات للسيطرة عليك. التزم بجدول صارم للنشاط البدني والركض عدة أيام في الأسبوع؛ فالرياضة تعمل كمحرقة مادية لطرد هرمونات التوتر والهلع السامة الراكدة في الخلايا وتدريب إرادتك السيادية."; break;
                case 6: title = "6. سيادة الامتنان وعقلية المشاهد الميدانية"; msg = "الذكاء العاطفي المتقدم: انسحب ذهنياً فوراً عند التعرض لأي استفزاز، وعكة تواصل، أو محاولة تهميش واجلس على مقعد 'المشاهد الميداني'. راقب الحدث ببرود وحلل نظام تشغيل الشخص المقابل بصفته سجيناً لجهله وصدماته الخاصة، لتنتزع سلطته النفسية عنك تماماً وتدير المشهد بوعي وثبات انفعالي بارد وسيادي."; break;
            }
        } else {
            switch(id) {
                case 1: title = "1. Soul Solitude and Attunement"; msg = "Solitude Protocol: Dedicate 10 minutes daily in absolute stillness without digital devices or phone notifications. Listen to your heartbeat, map your exact emotional state without filters, and capture the raw response inside your notebook to understand your soul."; break;
                case 2: title = "2. Unearthing Roots Matrix"; msg = "Deep Cleaning Matrix: Document your life trajectory chronologically within the 7-year stations. Empty all instantaneous toxic weights, fears, and blockages into separate side papers, then execute liberation by burning them immediately to send a powerful message to the subconscious."; break;
                case 3: title = "3. Restructuring & Inner Savior"; msg = "Saving Intervention: Summon a lingering old memory. Close your eyes and reanimate the scene in all its details. Enter using your current powerful, highly-aware self as a rapid intervention force. Stand as a barrier between your younger version and the wrongdoer, embracing them with a permanent protection vow."; break;
                case 4: title = "4. The Sovereign Dawn Protocol"; msg = "Morning Neural Programming: Master the first hour of your day before the world's noise strikes. Engage in deep breath control to signal safety to your nervous system, then read your Ancient Worthiness List and Letter of Self-Pride out loud to consolidate the new operating system against morning panic."; break;
                case 5: title = "5. Organized Incursion & Sovereignty"; msg = "Changing Healing Chemistry: Force your conscious boundaries out of the comfortable prison of the comfort zone. Stick to a rigorous running/exercise protocol to biochemically incinerate residual stress and panic hormones trapped inside your cells, training your wise sovereign will."; break;
                case 6: title = "6. Sovereign Gratitude Observer"; msg = "Advanced Conflict Management: When facing professional or familial provocation/marginalization, instantly retreat to the 'Midfield Observer Seat'. Analyze the other person's behavior coldly as a product of their ignorance or trauma, rendering them powerless."; break;
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(isArabic ? "مفهوم" : "Understood", null);
        AlertDialog dialog = builder.create();
        dialog.show();

        TextView messageView = dialog.findViewById(android.R.id.message);
        if (messageView != null) {
            messageView.setLineSpacing(8, 1);
        }
    }
}