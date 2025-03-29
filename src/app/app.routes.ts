import { Routes } from '@angular/router';
import { FormUsersComponent } from './modules/users/pages/form-users/form-users.component';

export const routes: Routes = [
  { path: '', component: FormUsersComponent }, 
  { path: '**', redirectTo: '' } 
];
