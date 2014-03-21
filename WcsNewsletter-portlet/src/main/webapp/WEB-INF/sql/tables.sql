create table WcsNewsletter_Category (
	categoryId LONG not null primary key,
	name VARCHAR(75) null,
	locale VARCHAR(75) null
);

create table WcsNewsletter_Label (
	labelId LONG not null primary key IDENTITY,
	tagId LONG
);

create table WcsNewsletter_Newsletter (
	newsletterId LONG not null primary key,
	subject VARCHAR(75) null,
	sender VARCHAR(75) null,
	contentId VARCHAR(75) null,
	contentVersion VARCHAR(75) null,
	templateId VARCHAR(75) null,
	templateVersion VARCHAR(75) null,
	parentId LONG,
	creationTime DATE null,
	state VARCHAR(75) null
);

create table WcsNewsletter_NewsletterConfig (
	configId LONG not null primary key,
	configKey VARCHAR(75) null,
	configValue VARCHAR(75) null
);

create table WcsNewsletter_Newsletter_Category (
	categoryId LONG not null,
	newsletterId LONG not null,
	primary key (categoryId, newsletterId)
);

create table WcsNewsletter_Newsletter_Label (
	labelId LONG not null,
	newsletterId LONG not null,
	primary key (labelId, newsletterId)
);

create table WcsNewsletter_Recipient (
	recipientId LONG not null primary key,
	newsletterId LONG,
	email VARCHAR(75) null,
	status VARCHAR(75) null,
	errorMessage VARCHAR(75) null
);

create table WcsNewsletter_Subscription (
	subscriptionId LONG not null primary key,
	userId LONG,
	email VARCHAR(75) null,
	subscriptionDate DATE null
);

create table WcsNewsletter_Subscription_Category (
	subscriptionId LONG not null,
	categoryId LONG not null,
	confirmationKey VARCHAR(75) null,
	cancellationKey VARCHAR(75) null,
	status VARCHAR(75) null,
	primary key (subscriptionId, categoryId)
);