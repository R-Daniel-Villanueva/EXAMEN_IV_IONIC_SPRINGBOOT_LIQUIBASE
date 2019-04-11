import { NgModule } from '@angular/core';
import { TestPipe } from './test/test';
import { MypipePipe } from './mypipe/mypipe';
@NgModule({
	declarations: [TestPipe,
    MypipePipe],
	imports: [],
	exports: [TestPipe,
    MypipePipe]
})
export class PipesModule {}
