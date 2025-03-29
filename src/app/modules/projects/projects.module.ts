import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectService } from './services/project.service';

@NgModule({
  imports: [
    CommonModule
  ],
  providers: [ProjectService]
})
export class ProjectModule { }
