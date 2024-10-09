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
import java.util.Date;

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

    private static void createData() {
        createUserAddress();
        createRoles();
        createUsers();
        createUserPhotos();

        createStableContactInfo();
        createStableAddress();
        createStables();
        createStablePhotos();
        createStableReviews();

        createHorseStatus();
        createHorses();
        createHorsePhotos();

        createHorseAnnouncements();
        createAnnouncementPhotos();

        createWorkoutTypes();
        createWorkouts();
    }

    private static void createUsers() {
        createUser("bob@gmail.com", "TestBob", "123", null, false, 1, 1, null);
        createUser("john@gmail.com", "TestJohn", "234", "112321", true, 2, 2, null);
    }

    private static void createUser(String email, String name, String password, String phoneNumber, boolean isActive, int roleId, int addressId, Timestamp updateTs) {
        User user = new User();

        if (userDao.findByEmail(email) == null) {
            user.setName(name);
            user.setEmail(email);
            user.setPassword(EncryptDecryptUtils.encrypt(password));
            user.setPhoneNumber(phoneNumber);
            user.setActive(isActive);
            user.setRole(roleDao.findById(roleId));
            user.setAddress(userAddressDao.findById(addressId));
            user.setUpdatedTs(updateTs);

            userDao.create(user);

            System.out.println("user is created" + userDao);
        } else {
            System.out.println("User with such email already exists");
        }
    }


    private static void createRoles() {
        createRole("DEFAULT_USER", null);
        createRole("STABLE_COACH", null);
        createRole("HORSE_OWNER", null);
        createRole("STABLE_MANAGER", null);
        createRole("STABLE_OWNER", null);
        createRole("ADMIN", "Отладочная роль");
    }

    private static void createRole(String name, String description) {
        Role role = new Role();
        role.setName(name);
        role.setDescription(description);
        roleDao.create(role);
    }


    private static void createUserAddress() {
        initUserAddress("Belarus", "Minsk");
        initUserAddress("Belarus", "Brest");
        initUserAddress("Poland", "Poland");
    }

    private static void initUserAddress(String country, String region) {
        UserAddress userAddress = new UserAddress();
        userAddress.setCountry(country);
        userAddress.setRegion(region);
        userAddressDao.create(userAddress);
    }


    private static void createUserPhotos() {
        createUserPhoto(1, "http://PhotoFirst", 1);
        createUserPhoto(2, "http://PhotoSecond", 1);
        createUserPhoto(3, "http://PhotoFour", 1);
        createUserPhoto(1, "http://PhotoFirst", 2);
        createUserPhoto(2, "http://PhotoSecond", 2);
    }

    private static void createUserPhoto(int photoOrder, String photoUrl, int userId) {
        UserPhoto userPhoto = new UserPhoto();
        userPhoto.setPhotoOrder(photoOrder);
        userPhoto.setPhotoUrl(photoUrl);
        userPhoto.setUserId(userDao.findById(userId));

        userPhotoDao.create(userPhoto);
    }


    private static void createHorses() {
        java.sql.Date age = new java.sql.Date(System.currentTimeMillis());

        createHorse("Bob", "jj", age, 1, 1, 1);
        createHorse("john", "abc", age, 2, 2, 1);
    }

    private static void createHorse(String name, String breed, java.sql.Date age,
                                    int horseStatusId, int horseStableOwner, int horseUserOwner) {
        Horse horse = new Horse();
        horse.setName(name);
        horse.setHorseBreed(breed);
        horse.setAge(age);
        horse.setStatus(horseStatusDao.findById(horseStatusId));
        horse.setHorseStableOwner(stableDao.findById(horseStableOwner));
        horse.setHorseUserOwner(userDao.findById(horseUserOwner));

        horseDao.create(horse);
    }


    private static void createHorseStatus() {
        initHorseStatus("GOOD", null);
        initHorseStatus("NOT GOOD", null);
    }

    private static void initHorseStatus(String name, String description) {
        HorseStatus horseStatus = new HorseStatus();
        horseStatus.setName(name);
        horseStatus.setDescription(description);

        horseStatusDao.create(horseStatus);
    }


    private static void createHorsePhotos() {
        createHorsePhoto(1, "http://PhotoFirst", 1);
        createHorsePhoto(2, "http://PhotoSecond", 1);
        createHorsePhoto(3, "http://PhotoFour", 1);
        createHorsePhoto(1, "http://PhotoFirst", 2);
        createHorsePhoto(2, "http://PhotoSecond", 2);
    }

    private static void createHorsePhoto(int photoOrder, String photoUrl, int horseId) {
        HorsePhoto horsePhoto = new HorsePhoto();
        horsePhoto.setPhotoOrder(photoOrder);
        horsePhoto.setPhotoUrl(photoUrl);
        horsePhoto.setHorseId(horseDao.findById(horseId));

        horsePhotoDao.create(horsePhoto);
    }


    private static void createStables() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        createStable("Ratomka", 1, 1, 1, 100, timestamp);
        createStable("Troya", 1, 2, 2, 50, timestamp);
    }

    private static void createStable(String name, int userOwnerId, int addressId, int contactInfoId, int horseCapacity, Timestamp createdTs) {
        Stable stable = new Stable();
        stable.setName(name);
        stable.setUserOwner(userDao.findById(userOwnerId));
        stable.setAddress(stableAddressDao.findById(addressId));
        stable.setContactInfo(stableContactInfoDao.findById(contactInfoId));
        stable.setHorseCapacity(horseCapacity);
        stable.setCreatedTs(createdTs);

        stableDao.create(stable);
    }


    private static void createStableContactInfo() {
        initStableContactInfo("375291233212", "stable1@gmail.com", "inst: stableContactInfo1");
        initStableContactInfo("80291234556", "teststable2@gmail.com", "inst: testStableContactInfo2");
    }

    private static void initStableContactInfo(String phoneNumber, String email, String description) {
        StableContactInfo stableContactInfo = new StableContactInfo();
        stableContactInfo.setPhoneNumber(phoneNumber);
        stableContactInfo.setEmail(email);
        stableContactInfo.setDescription(description);

        stableContactInfoDao.create(stableContactInfo);
    }


    private static void createStableAddress() {
        initStableAddress("Belarus", "Minsk", "Minsk", "Lenina", "1", "", "220056", "Вход с обратой стороны здания");
        initStableAddress("Poland", "Warsaw", "Warsaw", "St", "23", "1", "003457", null);
    }

    private static void initStableAddress(String country, String region, String city,
                                          String street, String building, String corpus,
                                          String postcode, String description) {
        StableAddress stableAddress = new StableAddress();
        stableAddress.setCountry(country);
        stableAddress.setRegion(region);
        stableAddress.setCity(city);
        stableAddress.setStreet(street);
        stableAddress.setBuilding(building);
        stableAddress.setCorpus(corpus);
        stableAddress.setPostcode(postcode);
        stableAddress.setDescription(description);

        stableAddressDao.create(stableAddress);
    }


    private static void createStablePhotos() {

        createStablePhoto(1, "http://PhotoFirst", 1);
        createStablePhoto(2, "http://PhotoSecond", 1);
        createStablePhoto(3, "http://PhotoThird", 1);
        createStablePhoto(1, "http://PhotoSecond", 2);
        createStablePhoto(2, "http://PhotoThird", 2);
    }

    private static void createStablePhoto(int photoOrder, String photoUrl, int stableId) {
        StablePhoto stablePhoto = new StablePhoto();
        stablePhoto.setPhotoOrder(photoOrder);
        stablePhoto.setPhotoUrl(photoUrl);
        stablePhoto.setStableId(stableDao.findById(stableId));

        stablePhotoDao.create(stablePhoto);
    }


    private static void createStableReviews() {
        createStableReview(5, "GOOD place", 1, 1);
        createStableReview(2, "Can be good", 2, 1);
    }

    private static void createStableReview(int rate, String comment, int stableId, int userId) {
        StableReview stableReview = new StableReview();
        stableReview.setStableRate(rate);
        stableReview.setComment(comment);
        stableReview.setUserId(userDao.findById(userId));
        stableReview.setStableId(stableDao.findById(stableId));

        stableReviewDao.create(stableReview);
    }


    private static void createAnnouncementPhotos() {
        createAnnouncementPhoto(1, "http://PhotoFirst", 1);
        createAnnouncementPhoto(2, "http://PhotoSecond", 1);
        createAnnouncementPhoto(3, "http://PhotoThird", 1);
        createAnnouncementPhoto(1, "http://PhotoFirst", 2);
        createAnnouncementPhoto(2, "http://PhotoSecond", 2);
    }

    private static void createAnnouncementPhoto(int photoOrder, String photoUrl, int announcementId) {
        AnnouncementPhoto announcementPhoto = new AnnouncementPhoto();
        announcementPhoto.setPhotoOrder(photoOrder);
        announcementPhoto.setPhotoUrl(photoUrl);
        announcementPhoto.setAnnouncement(horseAnnouncementDao.findById(announcementId));

        announcementPhotoDao.create(announcementPhoto);
    }


    private static void createHorseAnnouncements() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        createHorseAnnouncement(1, "Sell horse", "Sell horse, Minsk, 2000 BYN", 2000, true, 1, 10, timestamp);
        createHorseAnnouncement(2, "Horse", "Sell horse, Poland Warsaw, 3000 BYN", 3000, true, 1, 10, timestamp);
    }

    private static void createHorseAnnouncement(int horseId, String title, String description,
                                                int price, boolean status, int sellerId,
                                                int views, Timestamp createdTs) {
        HorseAnnouncement horseAnnouncement = new HorseAnnouncement();
        horseAnnouncement.setHorse(horseDao.findById(horseId));
        horseAnnouncement.setHeading(title);
        horseAnnouncement.setDescription(description);
        horseAnnouncement.setPrice(price);
        horseAnnouncement.setStatus(status);
        horseAnnouncement.setSellerId(userDao.findById(sellerId));
        horseAnnouncement.setViews(views);
        horseAnnouncement.setCreatedTs(createdTs);

        horseAnnouncementDao.create(horseAnnouncement);
    }


    private static void createWorkoutTypes() {
        createWorkoutType("field", "Horse riding in the field");
        createWorkoutType("default", "Horse riding in the parade ground");
        createWorkoutType("jumping", "Horse jumping");
    }

    private static void createWorkoutType(String name, String description) {
        WorkoutType workoutType = new WorkoutType();
        workoutType.setName(name);
        workoutType.setDescription(description);

        workoutTypeDao.create(workoutType);
    }


    private static void createWorkouts() {
        Date date = new Date();

        createWorkout(date, 1, 1, 1, 1, 1, 40, "BYN");
        createWorkout(date, 2, 1, 2, 2, 1, 50, "PLN");
    }

    private static void createWorkout(Date date, int workoutTypeId, int clientId, int stableId, int horseId, int coachId, int price, String currency) {
        Workout workout = new Workout();
        workout.setDate(date);
        workout.setWorkoutType(workoutTypeDao.findById(workoutTypeId));
        workout.setClient(userDao.findById(clientId));
        workout.setStable(stableDao.findById(stableId));
        workout.setHorse(horseDao.findById(horseId));
        workout.setCoach(userDao.findById(coachId));
        workout.setPrice(price);
        workout.setCurrency(currency);

        workoutDao.create(workout);
    }
}
