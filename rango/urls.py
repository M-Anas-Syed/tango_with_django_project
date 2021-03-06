from django.urls import path
from rango import views
from rango.views import AboutView

app_name = 'rango'

urlpatterns = [
    path('about/', views.AboutView.as_view(), name='about'),
    path('', views.IndexView.as_view(), name='index'),
    #path('search/', views.search, name='search'),
    path('category/<slug:category_name_slug>/', views.ShowCategoryView.as_view(), name='show_category'),
    path('add_category/', views.AddCategoryView.as_view(), name='add_category'),
    path('category/<slug:category_name_slug>/add_page/', views.AddPageView.as_view(), name='add_page'),
    path('restricted/', views.RestrictedView.as_view(), name='restricted'),
    path('goto/', views.GotoUrlView.as_view(), name='goto'),
    path('register_profile', views.RegisterProfileView.as_view(), name='register_profile'),
    path('profile/<username>/', views.ProfileView.as_view(), name='profile'),
    path('profiles/', views.ListProfilesView.as_view(), name='list_profiles')
]
