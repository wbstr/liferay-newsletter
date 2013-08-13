create index IX_DC6F9031 on WcsNewsletter_Category (locale);

create index IX_9DA7C3EA on WcsNewsletter_Label (tagId);

create index IX_2DC7D0B7 on WcsNewsletter_Newsletter (parentId);

create index IX_C8903A2D on WcsNewsletter_NewsletterConfig (configKey);

create index IX_E0BB3718 on WcsNewsletter_Newsletter_Category (categoryId);
create index IX_3B968213 on WcsNewsletter_Newsletter_Category (newsletterId);

create index IX_7A78C4C on WcsNewsletter_Newsletter_Label (labelId);
create index IX_D7D3431B on WcsNewsletter_Newsletter_Label (newsletterId);

create index IX_1D300988 on WcsNewsletter_Recipient (newsletterId);

create index IX_8074244A on WcsNewsletter_Subscription (email);
create index IX_50CBBEFC on WcsNewsletter_Subscription (userId);

create index IX_1D2BA1E5 on WcsNewsletter_Subscription_Category (cancellationKey);
create index IX_5DFE95F4 on WcsNewsletter_Subscription_Category (categoryId);
create index IX_95D9CDF3 on WcsNewsletter_Subscription_Category (confirmationKey);
create index IX_A619096D on WcsNewsletter_Subscription_Category (status);
create index IX_808FBE13 on WcsNewsletter_Subscription_Category (subscriptionId);