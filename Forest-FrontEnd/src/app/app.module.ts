import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; // this is needed!
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgbModule, NgbToastModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { ExamplesModule } from './examples/examples.module';

import { AppComponent } from './app.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { EventComponent } from './event/event.component';

@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        EventComponent
    ],
    imports: [
        BrowserAnimationsModule,
        HttpClientModule,
        NgbModule,
        FormsModule,
        NgbToastModule,
        RouterModule,
        AppRoutingModule,
        ComponentsModule,
        
        ExamplesModule,
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
