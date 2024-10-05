package org.example.finaljavaeeproject.test;

import org.example.finaljavaeeproject.dao.impl.announcementdaoimpl.AnnouncementPhotoDaoImpl;
import org.example.finaljavaeeproject.dao.impl.announcementdaoimpl.HorseAnnouncementDaoImpl;
import org.example.finaljavaeeproject.dao.impl.horsedaoimpl.HorseDaoImpl;
import org.example.finaljavaeeproject.dao.impl.horsedaoimpl.HorsePhotoDaoImpl;
import org.example.finaljavaeeproject.dao.impl.horsedaoimpl.HorseStatusDaoImpl;
import org.example.finaljavaeeproject.dao.impl.stabledaoimpl.*;
import org.example.finaljavaeeproject.dao.impl.userdaoimpl.RoleDaoImpl;
import org.example.finaljavaeeproject.dao.impl.userdaoimpl.UserAddressDaoImpl;
import org.example.finaljavaeeproject.dao.impl.userdaoimpl.UserDaoImpl;
import org.example.finaljavaeeproject.dao.impl.userdaoimpl.UserPhotoDaoImpl;
import org.example.finaljavaeeproject.dao.impl.workoutdaoimpl.WorkoutDaoImpl;
import org.example.finaljavaeeproject.dao.impl.workoutdaoimpl.WorkoutTypeDaoImpl;
import org.example.finaljavaeeproject.entity.announcement.AnnouncementPhoto;
import org.example.finaljavaeeproject.entity.announcement.HorseAnnouncement;
import org.example.finaljavaeeproject.entity.horse.Horse;
import org.example.finaljavaeeproject.entity.horse.HorsePhoto;
import org.example.finaljavaeeproject.entity.horse.HorseStatus;
import org.example.finaljavaeeproject.entity.stable.*;
import org.example.finaljavaeeproject.entity.user.Role;
import org.example.finaljavaeeproject.entity.user.User;
import org.example.finaljavaeeproject.entity.user.UserAddress;
import org.example.finaljavaeeproject.entity.user.UserPhoto;
import org.example.finaljavaeeproject.entity.workout.Workout;
import org.example.finaljavaeeproject.entity.workout.WorkoutType;
import org.example.finaljavaeeproject.util.EncryptDecryptUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddAllTestDataToDB {

    /**
     * This class used to test DB with TEST values
     */

    private static final UserDaoImpl userDao;
    private static final RoleDaoImpl roleDao;
    private static final UserAddressDaoImpl userAddressDao;
    public static final UserPhotoDaoImpl userPhotoDao;

    public static final HorseDaoImpl horseDao;
    public static final HorseStatusDaoImpl horseStatusDao;
    public static final HorsePhotoDaoImpl horsePhotoDao;

    public static final StableDaoImpl stableDao;
    public static final StableContactInfoDaoImpl stableContactInfoDao;
    public static final StableAddressDaoImpl stableAddressDao;
    public static final StablePhotoDaoImpl stablePhotoDao;
    public static final StableReviewDaoImpl stableReviewDao;

    public static final AnnouncementPhotoDaoImpl announcementPhotoDao;
    public static final HorseAnnouncementDaoImpl horseAnnouncementDao;

    public static final WorkoutDaoImpl workoutDao;
    public static final WorkoutTypeDaoImpl workoutTypeDao;

    static {
        userDao = new UserDaoImpl();
        roleDao = new RoleDaoImpl();
        userAddressDao = new UserAddressDaoImpl();
        userPhotoDao = new UserPhotoDaoImpl();

        horseDao = new HorseDaoImpl();
        horseStatusDao = new HorseStatusDaoImpl();
        horsePhotoDao = new HorsePhotoDaoImpl();

        stableDao = new StableDaoImpl();
        stableAddressDao = new StableAddressDaoImpl();
        stableContactInfoDao = new StableContactInfoDaoImpl();
        stablePhotoDao = new StablePhotoDaoImpl();
        stableReviewDao = new StableReviewDaoImpl();

        announcementPhotoDao = new AnnouncementPhotoDaoImpl();
        horseAnnouncementDao = new HorseAnnouncementDaoImpl();

        workoutDao = new WorkoutDaoImpl();
        workoutTypeDao = new WorkoutTypeDaoImpl();
    }


    public static void main(String[] args) {
        createData();
        System.out.println("Data Created");

    }

    public static void createData() {
        createUserAddress();
        createRoles();
        createUsers();
        createUserPhoto();

        createStableContactInfo();
        createStableAddress();
        createStable();
        createStablePhoto();
        createStableReview();

        createHorseStatus();
        createHorse();
        createHorsePhoto();

        createHorseAnnouncement();
        createAnnouncementPhoto();

        createWorkoutType();
        createWorkout();
    }

    public static void createUsers() {
        User user1 = new User();
        String email = "bob@gmail.com";

        if (userDao.findByEmail(email) == null) {
            user1.setName("TestBob");
            user1.setEmail(email);
            user1.setPassword(EncryptDecryptUtils.encrypt("123"));
            user1.setActive(false);
            user1.setRole(roleDao.findById(1));
            user1.setAddress(userAddressDao.findById(1));

            userDao.create(user1);

            System.out.println(userDao);
        } else {
            System.out.println("User with such email already exists");
        }
    }

    public static void createRoles() {
        Role defaultUserRole = new Role();
        defaultUserRole.setName("DEFAULT_USER");

        Role stableCoachRole = new Role();
        stableCoachRole.setName("STABLE_COACH");

        Role horseOwnerRole = new Role();
        horseOwnerRole.setName("HORSE_OWNER");

        Role stableManagerRole = new Role();
        stableManagerRole.setName("STABLE_MANAGER");

        Role stableOwnerRole = new Role();
        stableOwnerRole.setName("STABLE_OWNER");

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        adminRole.setDescription("Отладочная роль");

        List<Role> roles = new ArrayList<>();
        roles.add(defaultUserRole);
        roles.add(stableCoachRole);
        roles.add(horseOwnerRole);
        roles.add(stableManagerRole);
        roles.add(stableOwnerRole);
        roles.add(adminRole);


        roleDao.createAll(roles);
        System.out.println("Roles Created");
    }

    public static void createUserAddress() {
        UserAddress userAddressFirst = new UserAddress();
        userAddressFirst.setCountry("Belarus");
        userAddressFirst.setRegion("Minsk");

        UserAddress userAddressSecond = new UserAddress();
        userAddressSecond.setCountry("Belarus");
        userAddressSecond.setRegion("Brest");

        UserAddress userAddressThird = new UserAddress();
        userAddressThird.setCountry("Poland");
        userAddressThird.setRegion("Poland");


        List<UserAddress> userAddresses = new ArrayList<>();
        userAddresses.add(userAddressFirst);
        userAddresses.add(userAddressSecond);
        userAddresses.add(userAddressThird);

        userAddressDao.createAll(userAddresses);
    }

    public static void createUserPhoto() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        UserPhoto userPhotoFirst = new UserPhoto();
        userPhotoFirst.setPhotoOrder(1);
        userPhotoFirst.setPhotoUrl("http://PhotoFirst");
        userPhotoFirst.setCreatedTs(timestamp);
        userPhotoFirst.setUserId(userDao.findById(1));

        UserPhoto userPhotoSecond = new UserPhoto();
        userPhotoSecond.setPhotoOrder(2);
        userPhotoSecond.setPhotoUrl("http://PhotoSecond");
        userPhotoSecond.setCreatedTs(timestamp);
        userPhotoSecond.setUserId(userDao.findById(1));

        UserPhoto userPhotoThird = new UserPhoto();
        userPhotoThird.setPhotoOrder(3);
        userPhotoThird.setPhotoUrl("http://PhotoFour");
        userPhotoThird.setCreatedTs(timestamp);
        userPhotoThird.setUserId(userDao.findById(1));

        UserPhoto userPhotoForty = new UserPhoto();
        userPhotoForty.setPhotoOrder(1);
        userPhotoForty.setPhotoUrl("http://PhotoFirst");
        userPhotoForty.setCreatedTs(timestamp);
        userPhotoForty.setUserId(userDao.findById(1));

        UserPhoto userPhotoFive = new UserPhoto();
        userPhotoFive.setPhotoOrder(2);
        userPhotoFive.setPhotoUrl("http://PhotoSecond");
        userPhotoFive.setCreatedTs(timestamp);
        userPhotoFive.setUserId(userDao.findById(1));

        List<UserPhoto> userPhotos = new ArrayList<>();
        userPhotos.add(userPhotoFirst);
        userPhotos.add(userPhotoSecond);
        userPhotos.add(userPhotoThird);
        userPhotos.add(userPhotoForty);
        userPhotos.add(userPhotoFive);


        userPhotoDao.createAll(userPhotos);
    }

    public static void createHorse() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Horse horse1 = new Horse();

        Date age1 = new Date();

        horse1.setName("Bob");
        horse1.setHorseBreed("jj");
        horse1.setAge(new java.sql.Date(age1.getTime()));
        horse1.setHorseBreed("Abs");
        horse1.setCreatedTs(timestamp);
        horse1.setStatus(horseStatusDao.findById(1));
        horse1.setHorseStableOwner(stableDao.findById(1));
        horse1.setHorseUserOwner(userDao.findById(1));

        Horse horse2 = new Horse();

        Date age2 = new Date();

        horse2.setName("Bob");
        horse2.setHorseBreed("jj");
        horse2.setAge(new java.sql.Date(age2.getTime()));
        horse2.setHorseBreed("Abs");
        horse2.setCreatedTs(timestamp);
        horse2.setStatus(horseStatusDao.findById(2));
        horse2.setHorseStableOwner(stableDao.findById(2));
        horse2.setHorseUserOwner(userDao.findById(1));


        List<Horse> horses = new ArrayList<>();
        horses.add(horse1);
        horses.add(horse2);

        horseDao.createAll(horses);
    }

    public static void createHorseStatus() {
        HorseStatus horseStatus1 = new HorseStatus();
        horseStatus1.setName("GOOD");

        HorseStatus horseStatus2 = new HorseStatus();
        horseStatus2.setName("NOT GOOD");

        List<HorseStatus> horsesStatus = new ArrayList<>();
        horsesStatus.add(horseStatus1);
        horsesStatus.add(horseStatus2);

        horseStatusDao.createAll(horsesStatus);
    }

    public static void createHorsePhoto() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        HorsePhoto horsePhotoFirst = new HorsePhoto();
        horsePhotoFirst.setPhotoOrder(1);
        horsePhotoFirst.setPhotoUrl("http://PhotoFirst");
        horsePhotoFirst.setCreatedTs(timestamp);
        horsePhotoFirst.setHorseId(horseDao.findById(1));

        HorsePhoto horsePhotoSecond = new HorsePhoto();
        horsePhotoSecond.setPhotoOrder(2);
        horsePhotoSecond.setPhotoUrl("http://PhotoSecond");
        horsePhotoSecond.setCreatedTs(timestamp);
        horsePhotoSecond.setHorseId(horseDao.findById(1));

        HorsePhoto horsePhotoThird = new HorsePhoto();
        horsePhotoThird.setPhotoOrder(3);
        horsePhotoThird.setPhotoUrl("http://PhotoFour");
        horsePhotoThird.setCreatedTs(timestamp);
        horsePhotoThird.setHorseId(horseDao.findById(1));

        HorsePhoto horsePhotoForty = new HorsePhoto();
        horsePhotoForty.setPhotoOrder(1);
        horsePhotoForty.setPhotoUrl("http://PhotoFirst");
        horsePhotoForty.setCreatedTs(timestamp);
        horsePhotoForty.setHorseId(horseDao.findById(2));

        HorsePhoto horsePhotoFive = new HorsePhoto();
        horsePhotoFive.setPhotoOrder(2);
        horsePhotoFive.setPhotoUrl("http://PhotoSecond");
        horsePhotoFive.setCreatedTs(timestamp);
        horsePhotoFive.setHorseId(horseDao.findById(2));

        List<HorsePhoto> horsePhotos = new ArrayList<>();
        horsePhotos.add(horsePhotoFirst);
        horsePhotos.add(horsePhotoSecond);
        horsePhotos.add(horsePhotoThird);
        horsePhotos.add(horsePhotoForty);
        horsePhotos.add(horsePhotoFive);

        horsePhotoDao.createAll(horsePhotos);
    }


    public static void createStable() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Stable stable1 = new Stable();
        stable1.setName("Ratomka");
        stable1.setUserOwner(userDao.findById(1));
        stable1.setAddress(stableAddressDao.findById(1));
        stable1.setContactInfo(stableContactInfoDao.findById(1));
        stable1.setHorseCapacity(100);
        stable1.setCreatedTs(timestamp);

        Stable stable2 = new Stable();
        stable2.setName("Troya");
        stable2.setUserOwner(userDao.findById(1));
        stable2.setAddress(stableAddressDao.findById(2));
        stable2.setContactInfo(stableContactInfoDao.findById(2));
        stable2.setHorseCapacity(50);
        stable2.setCreatedTs(timestamp);

        List<Stable> stables = new ArrayList<>();
        stables.add(stable1);
        stables.add(stable2);

        stableDao.createAll(stables);
    }

    public static void createStableContactInfo() {
        StableContactInfo stableContactInfo1 = new StableContactInfo();
        stableContactInfo1.setPhoneNumber("+375291233212");
        stableContactInfo1.setEmail("stable1@gmail.com");
        stableContactInfo1.setDescription("inst: stableContactInfo1");


        StableContactInfo stableContactInfo2 = new StableContactInfo();
        stableContactInfo2.setPhoneNumber("80291234556");
        stableContactInfo2.setEmail("teststable2@gmail.com");
        stableContactInfo2.setDescription("inst: testStableContactInfo2");

        List<StableContactInfo> stableContactInfos = new ArrayList<>();
        stableContactInfos.add(stableContactInfo1);
        stableContactInfos.add(stableContactInfo2);

        stableContactInfoDao.createAll(stableContactInfos);
    }

    public static void createStableAddress() {
        StableAddress stableAddress1 = new StableAddress();
        stableAddress1.setCountry("Belarus");
        stableAddress1.setRegion("Minsk");
        stableAddress1.setCity("Minsk");
        stableAddress1.setStreet("Lenina");
        stableAddress1.setBuilding("1");
        stableAddress1.setCorpus("");
        stableAddress1.setPostcode("220056");
        stableAddress1.setDescription("Вход с обратой стороны здания");

        StableAddress stableAddress2 = new StableAddress();
        stableAddress2.setCountry("Poland");
        stableAddress2.setRegion("Warsaw");
        stableAddress2.setCity("Warsaw");
        stableAddress2.setStreet("St");
        stableAddress2.setBuilding("23");
        stableAddress2.setCorpus("1");
        stableAddress2.setPostcode("003457");

        List<StableAddress> stableAddresses = new ArrayList<>();
        stableAddresses.add(stableAddress1);
        stableAddresses.add(stableAddress2);

        stableAddressDao.createAll(stableAddresses);
    }

    public static void createStablePhoto() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        StablePhoto stablePhoto1 = new StablePhoto();
        stablePhoto1.setPhotoOrder(1);
        stablePhoto1.setPhotoUrl("http://PhotoFirst");
        stablePhoto1.setCreatedTs(timestamp);
        stablePhoto1.setStableId(stableDao.findById(1));

        StablePhoto stablePhoto2 = new StablePhoto();
        stablePhoto2.setPhotoOrder(2);
        stablePhoto2.setPhotoUrl("http://PhotoSecond");
        stablePhoto2.setCreatedTs(timestamp);
        stablePhoto2.setStableId(stableDao.findById(1));

        StablePhoto stablePhoto3 = new StablePhoto();
        stablePhoto3.setPhotoOrder(3);
        stablePhoto3.setPhotoUrl("http://PhotoFour");
        stablePhoto3.setCreatedTs(timestamp);
        stablePhoto3.setStableId(stableDao.findById(1));

        StablePhoto stablePhoto4 = new StablePhoto();
        stablePhoto4.setPhotoOrder(1);
        stablePhoto4.setPhotoUrl("http://PhotoFirst");
        stablePhoto4.setCreatedTs(timestamp);
        stablePhoto4.setStableId(stableDao.findById(2));

        StablePhoto stablePhoto5 = new StablePhoto();
        stablePhoto5.setPhotoOrder(2);
        stablePhoto5.setPhotoUrl("http://PhotoSecond");
        stablePhoto5.setCreatedTs(timestamp);
        stablePhoto5.setStableId(stableDao.findById(2));

        List<StablePhoto> stablePhotos = new ArrayList<>();
        stablePhotos.add(stablePhoto1);
        stablePhotos.add(stablePhoto2);
        stablePhotos.add(stablePhoto3);
        stablePhotos.add(stablePhoto4);
        stablePhotos.add(stablePhoto5);

        stablePhotoDao.createAll(stablePhotos);
    }

    public static void createStableReview() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        StableReview stableReview1 = new StableReview();
        stableReview1.setStableRate(5);
        stableReview1.setComment("GOOD place");
        stableReview1.setCreatedTs(timestamp);
        stableReview1.setUserId(userDao.findById(1));
        stableReview1.setStableId(stableDao.findById(1));

        StableReview stableReview2 = new StableReview();
        stableReview2.setStableRate(4);
        stableReview2.setComment("Can be good");
        stableReview2.setCreatedTs(timestamp);
        stableReview2.setUserId(userDao.findById(1));
        stableReview2.setStableId(stableDao.findById(2));
        stableReview2.setUpdatedTs(timestamp);

        List<StableReview> stableReviews = new ArrayList<>();
        stableReviews.add(stableReview1);
        stableReviews.add(stableReview2);

        stableReviewDao.createAll(stableReviews);
    }

    public static void createAnnouncementPhoto() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        AnnouncementPhoto announcementPhoto1 = new AnnouncementPhoto();
        announcementPhoto1.setPhotoOrder(1);
        announcementPhoto1.setPhotoUrl("http://PhotoFirst");
        announcementPhoto1.setCreatedTs(timestamp);
        announcementPhoto1.setAnnouncement(horseAnnouncementDao.findById(1));

        AnnouncementPhoto announcementPhoto2 = new AnnouncementPhoto();
        announcementPhoto2.setPhotoOrder(2);
        announcementPhoto2.setPhotoUrl("http://PhotoSecond");
        announcementPhoto2.setCreatedTs(timestamp);
        announcementPhoto2.setAnnouncement(horseAnnouncementDao.findById(1));

        AnnouncementPhoto announcementPhoto3 = new AnnouncementPhoto();
        announcementPhoto3.setPhotoOrder(3);
        announcementPhoto3.setPhotoUrl("http://PhotoFour");
        announcementPhoto3.setCreatedTs(timestamp);
        announcementPhoto3.setAnnouncement(horseAnnouncementDao.findById(1));

        AnnouncementPhoto announcementPhoto4 = new AnnouncementPhoto();
        announcementPhoto4.setPhotoOrder(1);
        announcementPhoto4.setPhotoUrl("http://PhotoFirst");
        announcementPhoto4.setCreatedTs(timestamp);
        announcementPhoto4.setAnnouncement(horseAnnouncementDao.findById(2));

        AnnouncementPhoto announcementPhoto5 = new AnnouncementPhoto();
        announcementPhoto5.setPhotoOrder(2);
        announcementPhoto5.setPhotoUrl("http://PhotoSecond");
        announcementPhoto5.setCreatedTs(timestamp);
        announcementPhoto5.setAnnouncement(horseAnnouncementDao.findById(2));

        List<AnnouncementPhoto> announcementPhotos = new ArrayList<>();
        announcementPhotos.add(announcementPhoto1);
        announcementPhotos.add(announcementPhoto2);
        announcementPhotos.add(announcementPhoto3);
        announcementPhotos.add(announcementPhoto4);
        announcementPhotos.add(announcementPhoto5);

        announcementPhotoDao.createAll(announcementPhotos);
    }

    public static void createHorseAnnouncement() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        HorseAnnouncement horseAnnouncement1 = new HorseAnnouncement();
        horseAnnouncement1.setHorse(horseDao.findById(1));
        horseAnnouncement1.setHeading("Sell horse");
        horseAnnouncement1.setDescription("Sell horse, Minsk, 2000 BYN");
        horseAnnouncement1.setPrice(2000);
        horseAnnouncement1.setStatus(true);
        horseAnnouncement1.setSellerId(userDao.findById(1));
        horseAnnouncement1.setViews(10);
        horseAnnouncement1.setCreatedTs(timestamp);

        HorseAnnouncement horseAnnouncement2 = new HorseAnnouncement();
        horseAnnouncement2.setHorse(horseDao.findById(2));
        horseAnnouncement2.setHeading("Horse");
        horseAnnouncement2.setDescription("Sell horse, Poland Warsaw, 3000 BYN");
        horseAnnouncement2.setPrice(3000);
        horseAnnouncement2.setStatus(true);
        horseAnnouncement2.setSellerId(userDao.findById(1));
        horseAnnouncement2.setViews(10);
        horseAnnouncement2.setCreatedTs(timestamp);

        List<HorseAnnouncement> announcements = new ArrayList<>();
        announcements.add(horseAnnouncement1);
        announcements.add(horseAnnouncement2);

        horseAnnouncementDao.createAll(announcements);
    }


    public static void createWorkoutType() {
        WorkoutType workoutType1 = new WorkoutType();
        workoutType1.setName("field");
        workoutType1.setDescription("Horse riding in the field");

        WorkoutType workoutType2 = new WorkoutType();
        workoutType2.setName("default");
        workoutType2.setDescription("Horse riding in the parade ground");

        WorkoutType workoutType3 = new WorkoutType();
        workoutType3.setName("jumping");
        workoutType3.setDescription("Horse jumping");

        List<WorkoutType> workoutTypes = new ArrayList<>();
        workoutTypes.add(workoutType1);
        workoutTypes.add(workoutType2);
        workoutTypes.add(workoutType3);

        workoutTypeDao.createAll(workoutTypes);
    }

    public static void createWorkout() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Workout workout1 = new Workout();
        workout1.setDate(date);
        workout1.setWorkoutType(workoutTypeDao.findById(1));
        workout1.setClient(userDao.findById(1));
        workout1.setStable(stableDao.findById(1));
        workout1.setHorse(horseDao.findById(1));
        workout1.setCoach(userDao.findById(1));
        workout1.setPrice(40);
        workout1.setCreatedTs(timestamp);

        Workout workout2 = new Workout();
        workout2.setDate(date);
        workout2.setWorkoutType(workoutTypeDao.findById(2));
        workout2.setClient(userDao.findById(1));
        workout2.setStable(stableDao.findById(2));
        workout2.setHorse(horseDao.findById(2));
        workout2.setCoach(userDao.findById(1));
        workout2.setPrice(50);
        workout2.setCreatedTs(timestamp);

        List<Workout> workouts = new ArrayList<>();
        workouts.add(workout1);
        workouts.add(workout2);

        workoutDao.createAll(workouts);
    }
}
