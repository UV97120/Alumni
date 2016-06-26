package vishal.alumni;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView leftNavigationView = (NavigationView) findViewById(R.id.left_view);
        leftNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle Left navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    Toast.makeText(MainActivity.this, "Left Drawer - HOME", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_awards) {
                    Toast.makeText(MainActivity.this, "Left Drawer - Awards", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_conect) {
                    Toast.makeText(MainActivity.this, "Left Drawer - Connect", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_showcase) {
                    Toast.makeText(MainActivity.this, "Left Drawer - SHOW-CASE", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_careers) {
                    Toast.makeText(MainActivity.this, "Left Drawer - CAREERS", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_blog) {
                    Toast.makeText(MainActivity.this, "Left Drawer - BLOG", Toast.LENGTH_SHORT).show();
                }else if (id == R.id.nav_contact) {
                    Toast.makeText(MainActivity.this, "Left Drawer - CONTACTS", Toast.LENGTH_SHORT).show();
                }else if (id == R.id.nav_aboutus) {
                    Toast.makeText(MainActivity.this, "Left Drawer - ABOUT-US", Toast.LENGTH_SHORT).show();
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        NavigationView rightNavigationView = (NavigationView) findViewById(R.id.right_view);
        rightNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle Right navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_login) {
                    Toast.makeText(MainActivity.this, "Right Drawer - LOGIN", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_register) {
                  //  Toast.makeText(MainActivity.this, "Right Drawer - REGISTEr", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Registration.class);
                    startActivity(intent);
                } 
                drawer.closeDrawer(GravityCompat.END); /*Important Line*/
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (drawer.isDrawerOpen(GravityCompat.END)) {  /*Closes the Appropriate Drawer*/
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
            System.exit(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_openright) {
            drawer.openDrawer(GravityCompat.END); /*Opens the Right Drawer*/
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}